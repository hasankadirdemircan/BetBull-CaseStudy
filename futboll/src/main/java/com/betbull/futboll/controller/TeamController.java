package com.betbull.futboll.controller;

import com.betbull.futboll.enums.Error;
import com.betbull.futboll.request.TeamRequest;
import com.betbull.futboll.response.TeamListResponse;
import com.betbull.futboll.response.TeamResponse;
import com.betbull.futboll.service.TeamService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/team")
@Api(value="Futboll Team Management System", description="Operations pertaining to team in futboll Management System")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public TeamResponse createTeam(@RequestBody TeamRequest req, HttpServletResponse httpRes){
        TeamResponse res = null;
        if(null == req.getTeam()){
            res = new TeamResponse(HttpServletResponse.SC_BAD_REQUEST, Error.ERR000, null);
        }else{
            try{
                res = new TeamResponse(HttpServletResponse.SC_OK, null, teamService.saveTeam(req.getTeam()));

            }catch (Exception ex){
                ex.printStackTrace();
                res = new TeamResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR001, null);
            }
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @PutMapping
    public TeamResponse updateTeam(@PathVariable(value = "id") Integer id, @RequestBody TeamRequest req, HttpServletResponse httpRes){
        TeamResponse res = null;
        if(null == req.getTeam()){
            res = new TeamResponse(HttpServletResponse.SC_BAD_REQUEST, Error.ERR998, null);
        }else{
            try{
                res = new TeamResponse(HttpServletResponse.SC_OK, null, teamService.updateTeam(id, req.getTeam()) );

            }catch (Exception ex){
                ex.printStackTrace();
                res = new TeamResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
            }
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @GetMapping("/{id}")
    public TeamResponse getTeam(@PathVariable(value = "id") Integer id, HttpServletResponse httpRes){
        TeamResponse res = null;
        try{
            res = new TeamResponse(HttpServletResponse.SC_OK, null, teamService.getTeam(id));
        }catch (Exception e){
            e.printStackTrace();
            res = new TeamResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @GetMapping
    public TeamListResponse getAllTeams(HttpServletResponse httpRes){
        TeamListResponse res = null;

        try{
            res = new TeamListResponse(HttpServletResponse.SC_OK, null, teamService.getAllTeams());
        }catch (Exception e){
            e.printStackTrace();
            res = new TeamListResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
        }
        httpRes.setStatus(res.getStatusCode());
        return res;

    }
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") Integer id){
        teamService.deleteTeam(id);
    }


}

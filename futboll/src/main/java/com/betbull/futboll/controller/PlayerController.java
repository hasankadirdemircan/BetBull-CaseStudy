package com.betbull.futboll.controller;

import com.betbull.futboll.enums.Error;
import com.betbull.futboll.request.PlayerCostRequest;
import com.betbull.futboll.request.PlayerRequest;
import com.betbull.futboll.request.SearchPlayerRequest;
import com.betbull.futboll.response.PlayerCostResponse;
import com.betbull.futboll.response.PlayerListResponse;
import com.betbull.futboll.response.PlayerResponse;
import com.betbull.futboll.service.PlayerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/player")
@Api(value="Futboll Player Management System", description="Operations pertaining to player in futboll Management System")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiOperation(value = "Create a player", response = PlayerResponse.class)
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successful Create Player"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),
            }
    )
    @PostMapping
    public PlayerResponse createPlayer(@ApiParam(value = "Player create object", required = true) @RequestBody PlayerRequest req, HttpServletResponse httpRes){
        PlayerResponse res = null;
        if(null == req.getPlayer()){
            res = new PlayerResponse(HttpServletResponse.SC_BAD_REQUEST, Error.ERR000, null);
        }else{
            try{
                res = new PlayerResponse(HttpServletResponse.SC_OK, null, playerService.savePlayer(req.getPlayer()) );

            }catch (Exception ex){
                ex.printStackTrace();
                res = new PlayerResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR001, null);
            }
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @PutMapping
    public PlayerResponse updatePlayer(@PathVariable(value = "id") Integer id, @RequestBody PlayerRequest req, HttpServletResponse httpRes){
        PlayerResponse res = null;
        if(null == req.getPlayer()){
            res = new PlayerResponse(HttpServletResponse.SC_BAD_REQUEST, Error.ERR998, null);
        }else{
            try{
                res = new PlayerResponse(HttpServletResponse.SC_OK, null, playerService.updatePlayer(id, req.getPlayer()) );

            }catch (Exception ex){
                ex.printStackTrace();
                res = new PlayerResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
            }
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayer(@PathVariable(value = "id") Integer id, HttpServletResponse httpRes){
        PlayerResponse res = null;
        try{
            res = new PlayerResponse(HttpServletResponse.SC_OK, null, playerService.getPlayer(id));
        }catch (Exception e){
            e.printStackTrace();
            res = new PlayerResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @GetMapping
    public PlayerListResponse getAllPlayers(HttpServletResponse httpRes){
        PlayerListResponse res = null;

        try{
            res = new PlayerListResponse(HttpServletResponse.SC_OK, null, playerService.getAllPlayers());
        }catch (Exception e){
            e.printStackTrace();
            res = new PlayerListResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
        }
        httpRes.setStatus(res.getStatusCode());
        return res;

    }
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") Integer id){
        playerService.deletePlayer(id);
    }

    @PostMapping(value = "/searchPlayer")
    public PlayerListResponse getSearchPlayer(@ApiParam(value = "Player search parameter", required = true)@RequestBody SearchPlayerRequest req, HttpServletResponse httpRes  ){
        PlayerListResponse res = null;
        try{
            res = new PlayerListResponse(HttpServletResponse.SC_OK, null, playerService.getSearchPlayerWithTeamAndYear(req.getSearchPlayer()));
        }catch (Exception e){
            e.printStackTrace();
            res = new PlayerListResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR000, null);
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

    @PostMapping("/cost")
    public PlayerCostResponse costPlayer(@ApiParam(value = "Player create object", required = true) @RequestBody PlayerCostRequest req, HttpServletResponse httpRes){
        PlayerCostResponse res = null;

        if(null == req.getPlayerId()){
            res = new PlayerCostResponse(HttpServletResponse.SC_BAD_REQUEST, Error.ERR000, null);
        }else{
            try{
                res = new PlayerCostResponse(HttpServletResponse.SC_OK, null, playerService.costPlayer(req.getPlayerId()));

            }catch (Exception ex){
                ex.printStackTrace();
                res = new PlayerCostResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, Error.ERR001, null);
            }
        }
        httpRes.setStatus(res.getStatusCode());
        return res;
    }

}

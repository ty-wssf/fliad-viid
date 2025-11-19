package com.fliad.viid.modular.cascadeplatform.controller;

import com.fliad.viid.modular.cascadeplatform.domain.KeepaliveRequest;
import com.fliad.viid.modular.cascadeplatform.domain.RegisterRequest;
import com.fliad.viid.modular.cascadeplatform.domain.ResponseStatusObject;
import com.fliad.viid.modular.cascadeplatform.domain.UnRegisterRequest;
import com.fliad.viid.modular.cascadeplatform.service.ViidSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.snack.ONode;
import org.noear.solon.annotation.*;
import org.noear.solon.validation.annotation.Valid;

@Api(tags = "视图库System控制器，提供给下级视图库调用")
@Controller
@Valid
@Mapping("/VIID/System")
public class ViidSystemController {

    @Inject
    ViidSystemService viidSystemService;

    @Produces("application/VIID+JSON;charset=UTF-8")
    @ApiOperation("注册")
    @Post
    @Mapping("Register")
    public ResponseStatusObject register(@Body String registerRequest) {
        return viidSystemService.register(ONode.deserialize(registerRequest, RegisterRequest.class));
    }

    @Produces("application/VIID+JSON;charset=UTF-8")
    @ApiOperation("心跳")
    @Post
    @Mapping("Keepalive")
    public ResponseStatusObject keepalive(@Body String keepaliveRequest) {
        return viidSystemService.keepalive(ONode.deserialize(keepaliveRequest, KeepaliveRequest.class));
    }

    @Produces("application/VIID+JSON;charset=UTF-8")
    @ApiOperation("注销")
    @Post
    @Mapping("UnRegister")
    public ResponseStatusObject unregister(@Body String unregisterRequest) {
        return viidSystemService.unregister(ONode.deserialize(unregisterRequest, UnRegisterRequest.class));
    }

}
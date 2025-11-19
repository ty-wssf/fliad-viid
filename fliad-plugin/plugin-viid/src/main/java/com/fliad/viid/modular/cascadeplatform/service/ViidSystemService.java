package com.fliad.viid.modular.cascadeplatform.service;

import com.fliad.viid.modular.cascadeplatform.domain.KeepaliveRequest;
import com.fliad.viid.modular.cascadeplatform.domain.RegisterRequest;
import com.fliad.viid.modular.cascadeplatform.domain.ResponseStatusObject;
import com.fliad.viid.modular.cascadeplatform.domain.UnRegisterRequest;


public interface ViidSystemService {

    ResponseStatusObject register(RegisterRequest registerRequest);

    ResponseStatusObject keepalive(KeepaliveRequest keepaliveRequest);
    
    ResponseStatusObject unregister(UnRegisterRequest unRegisterRequest);

}
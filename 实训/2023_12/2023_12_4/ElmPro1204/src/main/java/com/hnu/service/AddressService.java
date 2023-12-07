package com.hnu.service;

import com.hnu.po.Address;
import com.hnu.vo.ResponseObj;

public interface AddressService {

    ResponseObj add(Address address);

    ResponseObj update(Address address);

    ResponseObj del(Integer addressId);

    ResponseObj getByUser(Integer userId);

}

package com.hnu.service.impl;

import com.hnu.mapper.AddressMapper;
import com.hnu.po.Address;
import com.hnu.service.AddressService;
import com.hnu.vo.ResponseObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressMapper addressMapper;

    @Transactional
    @Override
    public ResponseObj add(Address address) {
        if (address==null){
           return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (address.getName()==null || "".equals(address.getName())){
           return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (address.getPhone()==null || "".equals(address.getPhone())){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        return addressMapper.insert(address)>0?ResponseObj.SUCCESS():ResponseObj.ERROR(666,"更新操作失败");
    }

    @Transactional
    @Override
    public ResponseObj update(Address address) {
        if (address==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (address.getAddressId()==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (address.getName()==null || "".equals(address.getName())){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        if (address.getPhone()==null || "".equals(address.getPhone())){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        return addressMapper.updateByPrimaryKey(address)>0?ResponseObj.SUCCESS():ResponseObj.ERROR(666,"更新操作失败");
    }

    @Transactional
    @Override
    public ResponseObj del(Integer addressId) {
        if (addressId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        return addressMapper.deleteByPrimaryKey(addressId)>0?ResponseObj.SUCCESS():ResponseObj.ERROR(666,"更新操作失败");
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseObj getByUser(Integer userId) {
        if (userId==null){
            return ResponseObj.ERROR(555,"参数校验失败");
        }
        return ResponseObj.SUCCESS(addressMapper.selectByUserId(userId));
    }
}
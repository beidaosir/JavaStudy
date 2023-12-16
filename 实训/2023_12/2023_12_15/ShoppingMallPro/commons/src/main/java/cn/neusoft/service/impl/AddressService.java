package cn.neusoft.service.impl;

import cn.neusoft.mapper.AddressMapper;
import cn.neusoft.po.Address;
import cn.neusoft.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hxj
 * @since 2023-12-13
 */
@Service
public class AddressService extends ServiceImpl<AddressMapper, Address> implements IAddressService {


}

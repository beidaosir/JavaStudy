package com.hnu.mapper;

import com.hnu.po.Pcas;
import com.hnu.query.PcasQuery;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface PcasMapper {

    @Insert("insert into t_pcas(code,name,parent,type) values(#{code},#{name},#{parent},#{type})")
    int add(Pcas pcas);

    List<Pcas> getByCondition(PcasQuery query);

}
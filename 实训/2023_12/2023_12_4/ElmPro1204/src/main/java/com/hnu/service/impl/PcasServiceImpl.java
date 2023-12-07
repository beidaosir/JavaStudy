package com.hnu.service.impl;


import com.hnu.mapper.PcasMapper;
import com.hnu.po.Pcas;
import com.hnu.query.PcasQuery;
import com.hnu.service.PcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PcasServiceImpl implements PcasService {

    @Autowired
    PcasMapper pcasMapper;

    @Transactional
    @Override
    public boolean addBatch(List<Pcas> pcasList) throws Exception {

        if (pcasList == null || pcasList.size()==0){
            return false;
        }

        for (Pcas pcas : pcasList) {
            int i = pcasMapper.add(pcas);
            if (i<=0){
                throw new Exception("批量添加失败");
            }
        }

        return true;
    }

    @Override
    public List<Pcas> getChildren(PcasQuery pcasQuery) {
        if (pcasQuery==null || pcasQuery.getType()==null){
            return null;
        }
        return pcasMapper.getByCondition(pcasQuery);
    }
}

package com.hnu.service;


import com.hnu.po.Pcas;
import com.hnu.query.PcasQuery;

import java.util.List;

public interface PcasService {

    boolean addBatch(List<Pcas> pcasList) throws Exception;

    List<Pcas> getChildren(PcasQuery pcasQuery);

}
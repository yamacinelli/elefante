package com.elefante.backend.arpemployerevent;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArpEmployerEventServiceImpl implements ArpEmployerEventService {

    private final ArpEmployerEventRepository arpEmployerEventRepository;
}

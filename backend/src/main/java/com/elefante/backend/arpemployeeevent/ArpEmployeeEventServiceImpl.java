package com.elefante.backend.arpemployeeevent;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArpEmployeeEventServiceImpl implements ArpEmployeeEventService {

    private final ArpEmployeeEventRepository arpEmployeeEventRepository;
}

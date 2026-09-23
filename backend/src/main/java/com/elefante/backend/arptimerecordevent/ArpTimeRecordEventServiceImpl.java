package com.elefante.backend.arptimerecordevent;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ArpTimeRecordEventServiceImpl implements ArpTimeRecordEventService {

    private final ArpTimeRecordEventRepository arpTimeRecordEventRepository;
}

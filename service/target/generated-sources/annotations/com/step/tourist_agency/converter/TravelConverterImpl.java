package com.step.tourist_agency.converter;

import com.step.tourist_agency.converter.customer.DateTimeMapper;
import com.step.tourist_agency.dto.LogDto;
import com.step.tourist_agency.dto.TravelDto;
import com.step.tourist_agency.entity.Travel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-22T20:24:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class TravelConverterImpl implements TravelConverter {

    @Override
    public Travel convert(TravelDto source) {
        if ( source == null ) {
            return null;
        }

        Travel travel = new Travel();

        travel.setId( source.getId() );
        travel.setName( source.getName() );

        return travel;
    }

    @Override
    public TravelDto convert(Travel source) {
        if ( source == null ) {
            return null;
        }

        LogDto log = null;

        log = travelToLogDto( source );

        TravelDto travelDto = new TravelDto( log );

        travelDto.setId( source.getId() );
        travelDto.setName( source.getName() );

        return travelDto;
    }

    protected LogDto travelToLogDto(Travel travel) {
        if ( travel == null ) {
            return null;
        }

        LogDto logDto = new LogDto();

        logDto.setDateCreation( DateTimeMapper.date( travel.getDateCreation() ) );
        logDto.setLastModified( DateTimeMapper.date( travel.getLastModified() ) );
        logDto.setVersion( travel.getVersion() );

        return logDto;
    }
}

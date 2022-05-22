package com.step.tourist_agency.converter;

import com.step.tourist_agency.converter.customer.DateTimeMapper;
import com.step.tourist_agency.dto.CustomerDto;
import com.step.tourist_agency.dto.LogDto;
import com.step.tourist_agency.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-22T20:24:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class CustomerConverterImpl implements CustomerConverter {

    @Override
    public Customer convert(CustomerDto source) {
        if ( source == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( source.getId() );
        customer.setName( source.getName() );

        return customer;
    }

    @Override
    public CustomerDto convert(Customer source) {
        if ( source == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setLog( customerToLogDto( source ) );
        customerDto.setId( source.getId() );
        customerDto.setName( source.getName() );

        return customerDto;
    }

    protected LogDto customerToLogDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        LogDto logDto = new LogDto();

        logDto.setDateCreation( DateTimeMapper.date( customer.getDateCreation() ) );
        logDto.setLastModified( DateTimeMapper.date( customer.getLastModified() ) );
        logDto.setVersion( customer.getVersion() );

        return logDto;
    }
}

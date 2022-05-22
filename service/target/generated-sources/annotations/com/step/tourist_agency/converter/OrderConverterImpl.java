package com.step.tourist_agency.converter;

import com.step.tourist_agency.converter.customer.DateTimeMapper;
import com.step.tourist_agency.dto.LogDto;
import com.step.tourist_agency.dto.OrderDto;
import com.step.tourist_agency.dto.OrderTravelDto;
import com.step.tourist_agency.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-22T20:24:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Amazon.com Inc.)"
)
@Component
public class OrderConverterImpl implements OrderConverter {

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public Order convert(OrderDto source) {
        if ( source == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( source.getId() );
        order.setCustomer( customerConverter.convert( source.getCustomer() ) );

        return order;
    }

    @Override
    public OrderDto convert(Order source) {
        if ( source == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setLog( orderToLogDto( source ) );
        orderDto.setId( source.getId() );
        orderDto.setCustomer( customerConverter.convert( source.getCustomer() ) );

        return orderDto;
    }

    @Override
    public OrderTravelDto convertFull(Order source) {
        if ( source == null ) {
            return null;
        }

        OrderTravelDto orderTravelDto = new OrderTravelDto();

        orderTravelDto.setLog( orderToLogDto1( source ) );
        orderTravelDto.setId( source.getId() );
        orderTravelDto.setCustomer( customerConverter.convert( source.getCustomer() ) );

        return orderTravelDto;
    }

    protected LogDto orderToLogDto(Order order) {
        if ( order == null ) {
            return null;
        }

        LogDto logDto = new LogDto();

        logDto.setDateCreation( DateTimeMapper.date( order.getDateCreation() ) );
        logDto.setLastModified( DateTimeMapper.date( order.getLastModified() ) );
        logDto.setVersion( order.getVersion() );

        return logDto;
    }

    protected LogDto orderToLogDto1(Order order) {
        if ( order == null ) {
            return null;
        }

        LogDto logDto = new LogDto();

        logDto.setDateCreation( DateTimeMapper.date( order.getDateCreation() ) );
        logDto.setLastModified( DateTimeMapper.date( order.getLastModified() ) );
        logDto.setVersion( order.getVersion() );

        return logDto;
    }
}

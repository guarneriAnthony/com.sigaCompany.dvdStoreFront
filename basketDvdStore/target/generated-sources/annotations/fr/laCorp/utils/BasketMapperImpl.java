package fr.laCorp.utils;

import fr.laCorp.dtos.BasketDto;
import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.dtos.BasketDvdGetDto;
import fr.laCorp.dtos.BasketGetDto;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.repositories.BasketRepositoryModel;
import fr.laCorp.services.BasketDvdServiceModel;
import fr.laCorp.services.BasketServiceModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-25T16:26:31+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
public class BasketMapperImpl implements BasketMapper {

    @Override
    public BasketDvdServiceModel basketDvdDtoToBasketDvdServiceModel(BasketDvdDto basketDvdDto) {
        if ( basketDvdDto == null ) {
            return null;
        }

        BasketDvdServiceModel basketDvdServiceModel = new BasketDvdServiceModel();

        basketDvdServiceModel.setIdDvd( basketDvdDto.idDvd() );
        basketDvdServiceModel.setQuantity( basketDvdDto.quantity() );
        basketDvdServiceModel.setPrice( basketDvdDto.price() );

        return basketDvdServiceModel;
    }

    @Override
    public BasketRepositoryModel basketServiceModelTobasketRepositoryModel(BasketServiceModel basketServiceModel) {
        if ( basketServiceModel == null ) {
            return null;
        }

        BasketRepositoryModel basketRepositoryModel = new BasketRepositoryModel();

        basketRepositoryModel.setId( basketServiceModel.getId() );
        basketRepositoryModel.setIdClient( basketServiceModel.getIdClient() );
        basketRepositoryModel.setTotalPrice( basketServiceModel.getTotalPrice() );

        return basketRepositoryModel;
    }

    @Override
    public BasketDvdServiceModel basketDvdRepositoryModelToBasketDvdServiceModel(BasketDvdRepositoryModel basketDvdRepositoryModel) {
        if ( basketDvdRepositoryModel == null ) {
            return null;
        }

        BasketDvdServiceModel basketDvdServiceModel = new BasketDvdServiceModel();

        basketDvdServiceModel.setId( basketDvdRepositoryModel.getId() );
        basketDvdServiceModel.setIdDvd( basketDvdRepositoryModel.getIdDvd() );
        basketDvdServiceModel.setQuantity( basketDvdRepositoryModel.getQuantity() );
        basketDvdServiceModel.setPrice( basketDvdRepositoryModel.getPrice() );

        return basketDvdServiceModel;
    }

    @Override
    public BasketDvdDto basketDvdServiceModelToBasketDvdDto(BasketDvdServiceModel byId) {
        if ( byId == null ) {
            return null;
        }

        int idDvd = 0;
        int quantity = 0;
        float price = 0.0f;

        idDvd = byId.getIdDvd();
        quantity = byId.getQuantity();
        price = byId.getPrice();

        BasketDvdDto basketDvdDto = new BasketDvdDto( idDvd, quantity, price );

        return basketDvdDto;
    }

    @Override
    public BasketDto basketServiceModelToBasketDto(BasketDvdServiceModel byId) {
        if ( byId == null ) {
            return null;
        }

        int idClient = 0;

        BasketDto basketDto = new BasketDto( idClient );

        return basketDto;
    }

    @Override
    public BasketDvdRepositoryModel basketDvdServiceModelToBasketDvdRepositoryModel(BasketDvdServiceModel basketDvdServiceModel, BasketRepositoryModel basket) {
        if ( basketDvdServiceModel == null && basket == null ) {
            return null;
        }

        BasketDvdRepositoryModel basketDvdRepositoryModel = new BasketDvdRepositoryModel();

        if ( basketDvdServiceModel != null ) {
            basketDvdRepositoryModel.setIdDvd( basketDvdServiceModel.getIdDvd() );
            basketDvdRepositoryModel.setQuantity( basketDvdServiceModel.getQuantity() );
            basketDvdRepositoryModel.setPrice( basketDvdServiceModel.getPrice() );
        }
        basketDvdRepositoryModel.setBasketId( basket );

        return basketDvdRepositoryModel;
    }

    @Override
    public List<BasketDvdDto> listBasketDvdServiceModelToBasketDvdDto(List<BasketDvdServiceModel> basketDvdServiceModels) {
        if ( basketDvdServiceModels == null ) {
            return null;
        }

        List<BasketDvdDto> list = new ArrayList<BasketDvdDto>( basketDvdServiceModels.size() );
        for ( BasketDvdServiceModel basketDvdServiceModel : basketDvdServiceModels ) {
            list.add( basketDvdServiceModelToBasketDvdDto( basketDvdServiceModel ) );
        }

        return list;
    }

    @Override
    public List<BasketDvdServiceModel> iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(Iterable<BasketDvdRepositoryModel> basketDvdRepositoryModelIterable) {
        if ( basketDvdRepositoryModelIterable == null ) {
            return null;
        }

        List<BasketDvdServiceModel> list = new ArrayList<BasketDvdServiceModel>();
        for ( BasketDvdRepositoryModel basketDvdRepositoryModel : basketDvdRepositoryModelIterable ) {
            list.add( basketDvdRepositoryModelToBasketDvdServiceModel( basketDvdRepositoryModel ) );
        }

        return list;
    }

    @Override
    public List<BasketServiceModel> iterableBasketRepositoryModelToListBasketServiceModel(Iterable<BasketRepositoryModel> basketRepositoryModelIterable) {
        if ( basketRepositoryModelIterable == null ) {
            return null;
        }

        List<BasketServiceModel> list = new ArrayList<BasketServiceModel>();
        for ( BasketRepositoryModel basketRepositoryModel : basketRepositoryModelIterable ) {
            list.add( basketRepositoryModelToBasketServiceModel( basketRepositoryModel ) );
        }

        return list;
    }

    @Override
    public BasketServiceModel basketDtoToBasketServiceModel(BasketDto basketDto) {
        if ( basketDto == null ) {
            return null;
        }

        BasketServiceModel basketServiceModel = new BasketServiceModel();

        basketServiceModel.setIdClient( basketDto.idClient() );

        return basketServiceModel;
    }

    @Override
    public List<BasketGetDto> listBasketServiceModelToBasketGetDto(List<BasketServiceModel> basketServiceModels) {
        if ( basketServiceModels == null ) {
            return null;
        }

        List<BasketGetDto> list = new ArrayList<BasketGetDto>( basketServiceModels.size() );
        for ( BasketServiceModel basketServiceModel : basketServiceModels ) {
            list.add( basketServiceModelToBasketGetDto( basketServiceModel ) );
        }

        return list;
    }

    @Override
    public BasketServiceModel basketRepositoryModelToBasketServiceModel(BasketRepositoryModel basket) {
        if ( basket == null ) {
            return null;
        }

        BasketServiceModel basketServiceModel = new BasketServiceModel();

        basketServiceModel.setId( basket.getId() );
        basketServiceModel.setIdClient( basket.getIdClient() );
        basketServiceModel.setTotalPrice( basket.getTotalPrice() );

        return basketServiceModel;
    }

    @Override
    public BasketGetDto BasketServiceModelToBasketGetDto(BasketServiceModel basketServiceModel, List<BasketDvdGetDto> basketDvdGetDtoList) {
        if ( basketServiceModel == null && basketDvdGetDtoList == null ) {
            return null;
        }

        BasketGetDto basketGetDto = new BasketGetDto();

        if ( basketServiceModel != null ) {
            basketGetDto.setId( basketServiceModel.getId() );
            basketGetDto.setIdClient( basketServiceModel.getIdClient() );
            basketGetDto.setTotalPrice( basketServiceModel.getTotalPrice() );
        }
        List<BasketDvdGetDto> list = basketDvdGetDtoList;
        if ( list != null ) {
            basketGetDto.setBasketDvdGetDtoList( new ArrayList<BasketDvdGetDto>( list ) );
        }

        return basketGetDto;
    }

    @Override
    public List<BasketDvdGetDto> listBasketDvdServiceModelToBasketDvdGetDto(List<BasketDvdServiceModel> basketDvdServiceModels) {
        if ( basketDvdServiceModels == null ) {
            return null;
        }

        List<BasketDvdGetDto> list = new ArrayList<BasketDvdGetDto>( basketDvdServiceModels.size() );
        for ( BasketDvdServiceModel basketDvdServiceModel : basketDvdServiceModels ) {
            list.add( basketDvdServiceModelToBasketDvdGetDto( basketDvdServiceModel ) );
        }

        return list;
    }

    protected BasketGetDto basketServiceModelToBasketGetDto(BasketServiceModel basketServiceModel) {
        if ( basketServiceModel == null ) {
            return null;
        }

        BasketGetDto basketGetDto = new BasketGetDto();

        basketGetDto.setId( basketServiceModel.getId() );
        basketGetDto.setIdClient( basketServiceModel.getIdClient() );
        basketGetDto.setTotalPrice( basketServiceModel.getTotalPrice() );

        return basketGetDto;
    }

    protected BasketDvdGetDto basketDvdServiceModelToBasketDvdGetDto(BasketDvdServiceModel basketDvdServiceModel) {
        if ( basketDvdServiceModel == null ) {
            return null;
        }

        BasketDvdGetDto basketDvdGetDto = new BasketDvdGetDto();

        basketDvdGetDto.setId( basketDvdServiceModel.getId() );
        basketDvdGetDto.setIdDvd( basketDvdServiceModel.getIdDvd() );
        basketDvdGetDto.setQuantity( basketDvdServiceModel.getQuantity() );
        basketDvdGetDto.setPrice( basketDvdServiceModel.getPrice() );

        return basketDvdGetDto;
    }
}

package fr.laCorp.utils;

import fr.laCorp.dtos.BasketDto;
import fr.laCorp.dtos.BasketDvdDto;
import fr.laCorp.dtos.BasketDvdGetDto;
import fr.laCorp.dtos.BasketGetDto;
import fr.laCorp.repositories.BasketDvdRepositoryModel;
import fr.laCorp.repositories.BasketRepositoryModel;
import fr.laCorp.services.BasketDvdServiceModel;
import fr.laCorp.services.BasketServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BasketMapper {
    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);


    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                     DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    BasketDvdServiceModel basketDvdDtoToBasketDvdServiceModel(BasketDvdDto basketDvdDto);
    BasketRepositoryModel basketServiceModelTobasketRepositoryModel(BasketServiceModel basketServiceModel);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            List<DTO>  ->  List<Service>  -->  List<Repository>
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //                                     END
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    // ------------------------------------------------------------------------------
    //                     Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------
    BasketDvdServiceModel basketDvdRepositoryModelToBasketDvdServiceModel(BasketDvdRepositoryModel basketDvdRepositoryModel);
    BasketDvdDto basketDvdServiceModelToBasketDvdDto(BasketDvdServiceModel byId);
    BasketDto basketServiceModelToBasketDto(BasketDvdServiceModel byId);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "basketId", source = "basket")
    BasketDvdRepositoryModel basketDvdServiceModelToBasketDvdRepositoryModel(BasketDvdServiceModel basketDvdServiceModel, BasketRepositoryModel basket );
    List<BasketDvdDto> listBasketDvdServiceModelToBasketDvdDto(List<BasketDvdServiceModel> basketDvdServiceModels);
    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------
    List<BasketDvdServiceModel> iterableBasketDvdRepositoryModelToListBasketDvdServiceModel(Iterable<BasketDvdRepositoryModel> basketDvdRepositoryModelIterable);
    List<BasketServiceModel> iterableBasketRepositoryModelToListBasketServiceModel(Iterable<BasketRepositoryModel> basketRepositoryModelIterable);


    BasketServiceModel basketDtoToBasketServiceModel(BasketDto basketDto);

    List<BasketGetDto> listBasketServiceModelToBasketGetDto(List<BasketServiceModel> basketServiceModels);

    BasketServiceModel basketRepositoryModelToBasketServiceModel(BasketRepositoryModel basket);

    @Mapping(target = "basketDvdGetDtoList", source = "basketDvdGetDtoList")
    BasketGetDto BasketServiceModelToBasketGetDto(BasketServiceModel basketServiceModel,List<BasketDvdGetDto> basketDvdGetDtoList);

    List<BasketDvdGetDto> listBasketDvdServiceModelToBasketDvdGetDto(List<BasketDvdServiceModel> basketDvdServiceModels);
}
    // ------------------------------------------------------------------------------
    //                                    END
    // ------------------------------------------------------------------------------

















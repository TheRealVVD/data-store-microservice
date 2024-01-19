package org.store.microservice.web.mapper;

import org.mapstruct.Mapper;
import org.store.microservice.model.Summary;
import org.store.microservice.web.dto.SummaryDto;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {



}

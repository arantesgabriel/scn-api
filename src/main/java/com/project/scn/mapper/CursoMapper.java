package com.project.scn.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.project.scn.DTO.CursoDTO;
import com.project.scn.domain.Curso;

@Mapper(componentModel = "spring")
public interface CursoMapper {
	
	CursoMapper INSTANCE = Mappers.getMapper( CursoMapper.class );
	
    @BeanMapping(nullValuePropertyMappingStrategy  = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "codigo", ignore = true)
    void DTOParaCurso(CursoDTO dto, @MappingTarget Curso entity);
}

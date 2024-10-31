package org.eafit.reto.mappers.interfaces;

import org.eafit.reto.contracts.request.PersonaRequest;
import org.eafit.reto.contracts.responses.PersonaResponse;
import org.eafit.reto.entities.PersonaPostgres;
import org.eafit.reto.entities.mongo.MongoPersona;
import org.eafit.reto.models.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaPostgres mapPersonaModelToPersonaPostgres(
            Persona model);

    Persona mapPersonaPostgresToPersonaModel(
            PersonaPostgres entity);

    MongoPersona mapPersonaToMongoPersona(
            Persona model);

    Persona mapMongoPersonaToPersona(
            MongoPersona entity);

    PersonaResponse mapPersonaModelToPersonaResponse(
            Persona model);

    Persona mapPersonaModelToPersonaRequest(
            PersonaRequest personaRequest);

    List<Persona> mapPersonaPostgresListToPersonaModelList(
            List<PersonaPostgres> entity);

    List<PersonaResponse> mapPersonaModelListToPersonaResponseList(
            List<Persona> entity);

    List<Persona> mapPersonaMongoListToPersonaModelList(
            List<MongoPersona> entity);
}

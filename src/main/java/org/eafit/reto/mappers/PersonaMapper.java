package org.eafit.reto.mappers;

import org.eafit.reto.contracts.request.PersonaRequest;
import org.eafit.reto.contracts.responses.PersonaResponse;
import org.eafit.reto.entities.PersonaPostgres;
import org.eafit.reto.entities.mongo.MongoPersona;
import org.eafit.reto.models.Persona;

public class PersonaMapper {

    public PersonaPostgres mapPersonaModelToPersonaPostgres(
            Persona model) {
        return PersonaPostgres.builder()
            .nombre(model.getNombre())
            .cedula(model.getCedula())
            .build();
    }

    public Persona mapPersonaPostgresToPersonaModel(
            PersonaPostgres entity) {
        return Persona.builder()
            .nombre(entity.getNombre())
            .cedula(entity.getCedula())
            .build();
    }

    public MongoPersona mapPersonaToMongoPersona(
            Persona model) {
        return MongoPersona.builder()
            .nombre(model.getNombre())
            .cedula(model.getCedula())
            .build();
    }

    public Persona mapMongoPersonaToPersona(
            MongoPersona entity) {
        return Persona.builder()
            .nombre(entity.getNombre())
            .cedula(entity.getCedula())
            .build();
    }

    public PersonaResponse mapPersonaToPersonaResponse(
            Persona model) {
        return PersonaResponse.builder()
            .nombre(model.getNombre())
            .cedula(model.getCedula())
            .build();
    }

    public Persona mapPersonaToPersonaRequest(
            PersonaRequest personaRequest) {
        return Persona.builder()
            .nombre(personaRequest.getNombre())
            .cedula(personaRequest.getCedula())
            .build();
    }
}

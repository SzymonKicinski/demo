/*
 * Copyright (c)
 * Author: Szymon Kiciński
 */

package person;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://www.jpworks.com/person", name = "PersonServicePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PersonServicePortType {

    @WebMethod(operationName = "GetPersonsByName", action = "http://www.jpworks.com/person/GetPersonsByName")
    @WebResult(name = "PersonsResponse", targetNamespace = "http://www.jpworks.com/person", partName = "parameters")
    public PersonsResponse getPersonsByName(

            @WebParam(partName = "parameters", name = "PersonByNameRequest", targetNamespace = "http://www.jpworks.com/person")
            PersonByNameRequest parameters
    );

    @WebMethod(operationName = "GetPersonById", action = "http://www.jpworks.com/person/GetPersonById")
    @WebResult(name = "PersonResponse", targetNamespace = "http://www.jpworks.com/person", partName = "parameters")
    public PersonResponse getPersonById(

            @WebParam(partName = "parameters", name = "PersonByIdRequest", targetNamespace = "http://www.jpworks.com/person")
            PersonByIdRequest parameters
    );

    @WebMethod(operationName = "GetPersonByPesel", action = "http://www.jpworks.com/person/GetPersonByPesel")
    @WebResult(name = "PersonResponse", targetNamespace = "http://www.jpworks.com/person", partName = "parameters")
    public PersonResponse getPersonByPesel(

            @WebParam(partName = "parameters", name = "GetPersonByPeselRequest", targetNamespace = "http://www.jpworks.com/person")
            PersonByPeselRequest parameters
    );
}

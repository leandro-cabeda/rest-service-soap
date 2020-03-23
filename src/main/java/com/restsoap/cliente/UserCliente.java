package com.restsoap.cliente;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.restsoap.wsdl.DeleteUsersRequest;
import com.restsoap.wsdl.DeleteUsersResponse;
import com.restsoap.wsdl.GetAllUsersRequest;
import com.restsoap.wsdl.GetAllUsersResponse;
import com.restsoap.wsdl.GetUsersRequest;
import com.restsoap.wsdl.GetUsersResponse;

public class UserCliente extends WebServiceGatewaySupport {

	public GetUsersResponse getUser(int id) {

		GetUsersRequest request = new GetUsersRequest();
		request.setId(id);

		// Essa chamada seria via remota
		GetUsersResponse response = (GetUsersResponse) getWebServiceTemplate()
				// Aqui envia a requisição onde consta o serviço Soap
				.marshalSendAndReceive("http://localhost:8180/ws/users", request,
						// Aqui adiciona callback na url desta aplicação
						new SoapActionCallback("http://restsoap.com/GetUsersRequest"));

		return response;
	}

	public GetAllUsersResponse getAllUsers() {

		GetAllUsersRequest request = new GetAllUsersRequest();

		GetAllUsersResponse response = (GetAllUsersResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8180/ws/users", request,
				new SoapActionCallback("http://restsoap.com/GetAllUsersRequest"));

		return response;

	}
	

	public DeleteUsersResponse deleteUsers(int id) {

		DeleteUsersRequest request = new DeleteUsersRequest();
		request.setId(id);

		DeleteUsersResponse response = (DeleteUsersResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8180/ws/users", request,
				new SoapActionCallback("http://restsoap.com/DeleteUsersRequest"));

		return response;

	}

}

/**
 * 
 */
package br.com.samuelweb.nfe;

import br.com.samuelweb.nfe.exception.NfeException;
import br.inf.portalfiscal.nfe.schema.retConsCad.TRetConsCad;
import br.inf.portalfiscal.nfe.schema.retEnvEventoCancNFe.TRetEnvEvento;
import br.inf.portalfiscal.nfe.schema.retdistdfeint.RetDistDFeInt;
import br.inf.portalfiscal.nfe.schema_4.enviNFe.TEnviNFe;
import br.inf.portalfiscal.nfe.schema_4.enviNFe.TRetEnviNFe;
import br.inf.portalfiscal.nfe.schema_4.retConsReciNFe.TRetConsReciNFe;
import br.inf.portalfiscal.nfe.schema_4.retConsSitNFe.TRetConsSitNFe;
import br.inf.portalfiscal.nfe.schema_4.retConsStatServ.TRetConsStatServ;


/**
 * @author Samuel Oliveira - samuk.exe@hotmail.com - www.samuelweb.com.br
 *
 */
public class Nfe {
	
	/**
	 * Construtor privado
	 */
	private Nfe() {
	}


	/**
	 * Classe Reponsavel Por Consultar a Distribuiçao da NFE na SEFAZ
	 *
	 * @param tipoCliente Informar DistribuicaoDFe.CPF ou DistribuicaoDFe.CNPJ
	 * @param cpfCnpj
	 * @param tipoConsulta Informar DistribuicaoDFe.NSU ou DistribuicaoDFe.CHAVE
	 * @param nsuChave
	 * @return
	 * @throws NfeException
	 */
	public static RetDistDFeInt distribuicaoDfe(String tipoCliente, String cpfCnpj , String tipoConsulta , String nsuChave) throws NfeException{

		return DistribuicaoDFe.consultaNfe(tipoCliente, cpfCnpj , tipoConsulta , nsuChave);

	}

	/**
	 * Metodo Responsavel Buscar o Status de Serviço do Servidor da Sefaz
	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
	 * 
	 * @param tipo
	 * @return
	 * @throws NfeException
	 */
	public static TRetConsStatServ statusServico(String tipo) throws NfeException{
		
		return Status.statusServico(tipo);
		
	}
	
	/**
	 * Classe Reponsavel Por Consultar o status da NFE na SEFAZ
	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
	 *
	 * @param chave
	 * @param tipo
	 * @return TRetConsSitNFe
	 * @throws NfeException
	 */
	public static TRetConsSitNFe consultaXml(String chave, String tipo) throws NfeException{

		return ConsultaXml.consultaXml(chave , tipo);

	}

	/**
	 * Classe Reponsavel Por Consultar o cadastro do Cnpj/CPF na SEFAZ
	 *
	 * @param tipo Usar ConsultaCadastro.CNPJ ou ConsultaCadastro.CPF
	 * @param cnpjCpf
	 * @return TRetConsCad
	 * @throws NfeException
	 */
	public static TRetConsCad consultaCadastro(String tipo, String cnpjCpf) throws NfeException{

		return ConsultaCadastro.consultaCadastro(tipo, cnpjCpf);

	}

	/**
	 * Classe Reponsavel Por Consultar o retorno da NFE na SEFAZ
	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
	 *
	 * @param recibo
	 * @param tipo
	 * @return
	 * @throws NfeException
	 */
	public static TRetConsReciNFe consultaRecibo(String recibo, String tipo) throws NfeException{

		return ConsultaRecibo.reciboNfe(recibo, tipo);

	}
//
//	/**
//	 * Classe Reponsavel Por Inutilizar a NFE na SEFAZ
//	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
//	 *
//	 * @param inutNFe
//	 * @param valida
//	 * @param tipo
//	 * @return
//	 * @throws NfeException
//	 */
//	public static TRetInutNFe inutilizacao(TInutNFe inutNFe, boolean valida, String tipo) throws NfeException{
//
//		return Inutilizar.inutiliza(inutNFe , valida, tipo);
//
//	}

	/**
	 * Metodo para Montar a NFE.
	 *
	 * @param enviNFe
	 * @param valida
	 * @return
	 * @throws NfeException
	 */
	public static TEnviNFe montaNfe(TEnviNFe enviNFe, boolean valida) throws NfeException{

		return Enviar.montaNfe(enviNFe , valida);

	}

	/**
	 * Metodo para Enviar a NFE.
	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
	 *
	 * @param enviNFe
	 * @param tipo
	 * @return
	 * @throws NfeException
	 */
	public static TRetEnviNFe enviarNfe(TEnviNFe enviNFe, String tipo) throws NfeException{

		return Enviar.enviaNfe(enviNFe, tipo);

	}

	/**
	 * 	 * Metodo para Cancelar a NFE.
	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
	 *
	 * @param chave
	 * @param protocolo
	 * @param cnpj
	 * @param motivo
	 * @param tipo
	 * @return
	 * @throws NfeException
	 */

	public static TRetEnvEvento cancelarNfe(String chave, String protocolo, String cnpj, String motivo, String tipo) throws NfeException{

		return Cancelar.eventoCancelamento(chave, protocolo, cnpj, motivo, tipo);

	}

//	/**
//	 * 	 * Metodo para Envio da Carta De Correção da NFE.
//	 * No tipo Informar ConstantesUtil.NFE ou ConstantesUtil.NFCE
//	 *
//	 * @param evento
//	 * @param valida
//	 * @param tipo
//	 * @return
//	 * @throws NfeException
//	 */
//	public static br.inf.portalfiscal.nfe.schema.TRetEnvEvento cce(br.inf.portalfiscal.nfe.schema.TEnvEvento evento, boolean valida, String tipo) throws NfeException{
//
//		return Evento.eventoCce(evento , valida,tipo);
//
//	}
//
//	/**
//	 * Metodo para Manifestação da NFE.
//	 *
//	 * @param envEvento
//	 * @param valida
//	 * @return
//	 * @throws NfeException
//	 */
//	public static br.inf.portalfiscal.nfe.schema.TRetEnvEvento manifestacao(br.inf.portalfiscal.nfe.schema.TEnvEvento envEvento, boolean valida) throws NfeException {
//
//		return Evento.eventoManifestacao(envEvento , valida);
//
//	}
//
	
}

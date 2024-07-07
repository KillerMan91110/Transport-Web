package com.example.proyecto.web.transporte.guia_remision;

import java.util.List;
import java.util.Optional;

import com.example.proyecto.web.transporte.dto.GuiaRemisionDto;
import com.example.proyecto.web.transporte.empleados.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GuiaRemisionService implements IGuiaRemisionService {

    @Autowired
    private IGuiaRemision dataGuiaRemision;

    @Autowired
    private IEmpleadosService empleadosService;

    @Override
    public List<GuiaRemision> Listar() {
        return (List<GuiaRemision>) dataGuiaRemision.findAll();
    }

    @Override
    public List<GuiaRemision> ListarPorEmpleado(int id) {
        return dataGuiaRemision.buscarPorIdEmpleado(id);
    }

    @Override
    public GuiaRemisionDto ConsultarId(int id) {
        GuiaRemision guiaRemision = dataGuiaRemision.findById(id).orElse(new GuiaRemision());
        return GuiaRemisionDto.builder()
                .NumFactura(guiaRemision.getNumFactura())
                .PuntoPartida(guiaRemision.getPuntoLlegada())
                .PuntoLlegada(guiaRemision.getPuntoLlegada())
                .Destinatario(guiaRemision.getDestinatario())
                .DocumentoDestinatario(guiaRemision.getDocumentoDestinatario())
                .Proveedor(guiaRemision.getProveedor())
                .DocumentoProveedor(guiaRemision.getDocumentoProveedor())
                .MotivoTraslado(guiaRemision.getMotivoTraslado())
                .ModalidadTraslado(guiaRemision.getModalidadTraslado())
                .FechaEmision(guiaRemision.getFechaEmision())
                .HoraEmision(guiaRemision.getHoraEmision())
                .FechaTraslado(guiaRemision.getFechaTraslado())
                .NumeroPedido(guiaRemision.getNumeroPedido())
                .RazonSocialTransportista(guiaRemision.getRazonSocialTransportista())
                .ructransportista(guiaRemision.getRUCTransportista())
                .NumeroMTC(guiaRemision.getNumeroMTC())
                .NumeroPlaca(guiaRemision.getNumeroPlaca())
                .IdProducto(guiaRemision.getIdProducto())
                .CodigoProducto(guiaRemision.getCodigoProducto())
                .DescripcionProducto(guiaRemision.getCodigoProducto())
                .CantidadProducto(guiaRemision.getCantidadProducto())
                .UnidadMedida(guiaRemision.getUnidadMedida())
                .PesoProducto(guiaRemision.getPesoProducto())
                .Observacion(guiaRemision.getObservacion())
                .estado(guiaRemision.getEstado())
                .idEmpleado(guiaRemision.getEmpleados().getId())
                .build();
    }

    @Override
    public void GuardarDto(GuiaRemisionDto guiaRemision) {
        dataGuiaRemision.save(GuiaRemision.builder()
                        .NumFactura(guiaRemision.getNumFactura())
                        .PuntoPartida(guiaRemision.getPuntoLlegada())
                        .PuntoLlegada(guiaRemision.getPuntoLlegada())
                        .Destinatario(guiaRemision.getDestinatario())
                        .DocumentoDestinatario(guiaRemision.getDocumentoDestinatario())
                        .Proveedor(guiaRemision.getProveedor())
                        .DocumentoProveedor(guiaRemision.getDocumentoProveedor())
                        .MotivoTraslado(guiaRemision.getMotivoTraslado())
                        .ModalidadTraslado(guiaRemision.getModalidadTraslado())
                        .FechaEmision(guiaRemision.getFechaEmision())
                        .HoraEmision(guiaRemision.getHoraEmision())
                        .FechaTraslado(guiaRemision.getFechaTraslado())
                        .NumeroPedido(guiaRemision.getNumeroPedido())
                        .RazonSocialTransportista(guiaRemision.getRazonSocialTransportista())
                        .RUCTransportista(guiaRemision.getRuctransportista())
                        .NumeroMTC(guiaRemision.getNumeroMTC())
                        .NumeroPlaca(guiaRemision.getNumeroPlaca())
                        .IdProducto(guiaRemision.getIdProducto())
                        .CodigoProducto(guiaRemision.getCodigoProducto())
                        .DescripcionProducto(guiaRemision.getCodigoProducto())
                        .CantidadProducto(guiaRemision.getCantidadProducto())
                        .UnidadMedida(guiaRemision.getUnidadMedida())
                        .PesoProducto(guiaRemision.getPesoProducto())
                        .Observacion(guiaRemision.getObservacion())
                        .estado(guiaRemision.getEstado())
                        .empleados(empleadosService.ConsultarId(guiaRemision.getIdEmpleado()).orElse(null))
                .build());
    }

    @Override
    public void actualizar(int id, GuiaRemisionDto guiaRemisionDto) {
        Optional<GuiaRemision> guiaRemisionOptional = dataGuiaRemision.findById(id);
        if (guiaRemisionOptional.isPresent()){
            GuiaRemision guiaRemision = guiaRemisionOptional.orElse(new GuiaRemision());
            guiaRemision.setPuntoPartida(guiaRemisionDto.getPuntoPartida());
            guiaRemision.setPuntoLlegada(guiaRemisionDto.getPuntoLlegada());
            guiaRemision.setDestinatario(guiaRemisionDto.getDestinatario());
            guiaRemision.setDocumentoDestinatario(guiaRemisionDto.getDocumentoDestinatario());
            guiaRemision.setProveedor(guiaRemisionDto.getProveedor());
            guiaRemision.setDocumentoProveedor(guiaRemisionDto.getDocumentoProveedor());
            guiaRemision.setMotivoTraslado(guiaRemisionDto.getMotivoTraslado());
            guiaRemision.setModalidadTraslado(guiaRemisionDto.getModalidadTraslado());
            guiaRemision.setFechaEmision(guiaRemisionDto.getFechaEmision());
            guiaRemision.setHoraEmision(guiaRemisionDto.getHoraEmision());
            guiaRemision.setFechaTraslado(guiaRemision.getFechaTraslado());
            guiaRemision.setNumeroPedido(guiaRemision.getNumeroPedido());
            guiaRemision.setRazonSocialTransportista(guiaRemision.getRazonSocialTransportista());
            guiaRemision.setRUCTransportista(guiaRemision.getRUCTransportista());
            guiaRemision.setNumeroMTC(guiaRemision.getNumeroMTC());
            if (guiaRemision.getEstado() == Estado.PEND){
                guiaRemision.setEmpleados(empleadosService.ConsultarId(guiaRemisionDto.getIdEmpleado()).orElse(guiaRemision.getEmpleados()));
            }
            guiaRemision.setNumeroPlaca(guiaRemisionDto.getNumeroPlaca());
            dataGuiaRemision.save(guiaRemision);
        }
    }

    @Override
    public void Guardar(GuiaRemision guiaRemision) {
        dataGuiaRemision.save(guiaRemision);
    }

    @Transactional
    @Override
    public boolean actualizarEstadoGuia(int id, String estado) {
        return (dataGuiaRemision.updateEstadoGuia(id, estado) > 0);
    }

    @Override
    public void Eliminar(int id) {
        dataGuiaRemision.deleteById(id);
    }

    @Override
    public List<GuiaRemision> Buscar(String dato) {
        return dataGuiaRemision.buscarPorTodo(dato);
    }

    @Override
    public List<GuiaRemision> ListarOrdenAscendente() {
        return dataGuiaRemision.OrdenAscendente();
    }

    @Override
    public List<GuiaRemision> ListarOrdenDescendente() {
        return dataGuiaRemision.OrdenDescendente();
    }

}

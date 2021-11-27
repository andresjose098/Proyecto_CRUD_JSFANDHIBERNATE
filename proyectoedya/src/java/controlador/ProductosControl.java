/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.inject.Named;
//import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.ProductoDao;
import modelo.entidad.Producto;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class ProductosControl {

    /**
     * Creates a new instance of ProductoControl
     */
    private List<Producto> listaProducto;
    private Producto producto;

    public ProductosControl() {
        producto = new Producto();
    }

    public List<Producto> getListaProductos() {
        ProductoDao ad = new ProductoDao();
        listaProducto = ad.listarPRODUCTOS();
        return listaProducto;
    }

    public void setListaProductos(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void limpiarProducto() {
        producto = new Producto();
    }

    public void agregarProducto() {
        ProductoDao ad = new ProductoDao();
        ad.agregar(producto);
    }

    public void modificarProducto() {
        ProductoDao ad = new ProductoDao();
        ad.modificar(producto);
        limpiarProducto();
    }

    public void eliminarProducto() {
        ProductoDao ad = new ProductoDao();
        ad.eliminar(producto);
        limpiarProducto();
    }
}

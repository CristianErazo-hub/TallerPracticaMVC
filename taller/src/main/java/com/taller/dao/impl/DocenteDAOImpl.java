package com.taller.dao.impl;

import com.taller.dao.DocenteDAO;
import com.taller.modelo.Docente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAOImpl implements DocenteDAO {

    private Connection conexion;

    public DocenteDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crear(Docente docente) {
        String sql = "INSERT INTO docente (nombre, especialidad) VALUES (?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Docente obtener(int id) {
        String sql = "SELECT * FROM docente WHERE id = ?";
        Docente docente = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                docente = new Docente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especialidad")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return docente;
    }

    @Override
    public List<Docente> listar() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT * FROM docente";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Docente d = new Docente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especialidad")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Docente docente) {
        String sql = "UPDATE docente SET nombre = ?, especialidad = ? WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getEspecialidad());
            ps.setInt(3, docente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM docente WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
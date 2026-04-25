package com.taller.dao.impl;

import com.taller.dao.MateriaDAO;
import com.taller.modelo.Materia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAOImpl implements MateriaDAO {

    private Connection conexion;

    public MateriaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crear(Materia materia) {
        String sql = "INSERT INTO materia (nombre_materia, creditos) VALUES (?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getCreditos());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Materia obtener(int id) {
        String sql = "SELECT * FROM materia WHERE id = ?";
        Materia materia = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre_materia"),
                        rs.getInt("creditos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materia;
    }

    @Override
    public List<Materia> listar() {
        List<Materia> lista = new ArrayList<>();
        String sql = "SELECT * FROM materia";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Materia m = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre_materia"),
                        rs.getInt("creditos"));
                lista.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Materia materia) {
        String sql = "UPDATE materia SET nombre_materia = ?, creditos = ? WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getCreditos());
            ps.setInt(3, materia.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM materia WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
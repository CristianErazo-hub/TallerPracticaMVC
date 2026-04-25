package com.taller.dao.impl;

import com.taller.dao.GrupoDAO;
import com.taller.modelo.Grupo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAOImpl implements GrupoDAO {

    private Connection conexion;

    public GrupoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crear(Grupo grupo) {
        String sql = "INSERT INTO grupo (id_materia, id_docente, aula, horario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, grupo.getIdMateria());
            ps.setInt(2, grupo.getIdDocente());
            ps.setString(3, grupo.getAula());
            ps.setString(4, grupo.getHorario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Grupo obtener(int id) {
        String sql = "SELECT * FROM grupo WHERE id = ?";
        Grupo grupo = null;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                grupo = new Grupo(
                        rs.getInt("id"),
                        rs.getInt("id_materia"),
                        rs.getInt("id_docente"),
                        rs.getString("aula"),
                        rs.getString("horario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupo;
    }

    @Override
    public List<Grupo> listar() {
        List<Grupo> lista = new ArrayList<>();
        String sql = "SELECT * FROM grupo";

        try (PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Grupo g = new Grupo(
                        rs.getInt("id"),
                        rs.getInt("id_materia"),
                        rs.getInt("id_docente"),
                        rs.getString("aula"),
                        rs.getString("horario"));
                lista.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Grupo grupo) {
        String sql = "UPDATE grupo SET id_materia = ?, id_docente = ?, aula = ?, horario = ? WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, grupo.getIdMateria());
            ps.setInt(2, grupo.getIdDocente());
            ps.setString(3, grupo.getAula());
            ps.setString(4, grupo.getHorario());
            ps.setInt(5, grupo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM grupo WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
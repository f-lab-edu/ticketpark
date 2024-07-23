package com.ticketpark.configuration.mybatis.typeHandler;

import com.ticketpark.performance.model.entity.Genre;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Genre.class)
public class GenreTypeHandler implements TypeHandler<Genre> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Genre parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Genre getResult(ResultSet rs, String columnName) throws SQLException {
        String genreKey = rs.getString(columnName);
        return getGenre(genreKey);
    }

    @Override
    public Genre getResult(ResultSet rs, int columnIndex) throws SQLException {
        String genreKey = rs.getString(columnIndex);
        return getGenre(genreKey);
    }

    @Override
    public Genre getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String genreKey = cs.getString(columnIndex);
        return getGenre(genreKey);
    }

    private Genre getGenre(String genreKey){
        Genre genre = Genre.CONCERT;
        switch (genreKey){
            case "CO":
                genre = Genre.CONCERT;
                break;
            /*case "MUs":
                genre = Genre.MUSICAL;
                break;
            case "SP":
                genre = Genre.SPORT;
                break;*/
            default:
                genre = Genre.CONCERT;
            break;
        }
        return genre;
    }
}

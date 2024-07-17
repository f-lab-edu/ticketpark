package com.ticketpark.ticket.member.model.typeHandler;

import com.ticketpark.ticket.member.model.entity.Role;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(Role.class)
public class RoleTypeHandler implements TypeHandler<Role> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getValue());
    }

    @Override
    public Role getResult(ResultSet rs, String columnName) throws SQLException {
        String roleKey = rs.getString(columnName);
        return getMemberRole(roleKey);
    }

    @Override
    public Role getResult(ResultSet rs, int columnIndex) throws SQLException {
        String roleKey = rs.getString(columnIndex);
        return getMemberRole(roleKey);
    }

    @Override
    public Role getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String roleKey = cs.getString(columnIndex);
        return getMemberRole(roleKey);
    }

    private Role getMemberRole(String roleKey) {
        Role role = null;
        switch (roleKey) {
            case "A" :
                role = Role.ADMIN;
                break;
            case "U" :
                role = Role.USER;
                break;
            default :
                role = Role.USER;
                break;
        }
        return role;
    }
}

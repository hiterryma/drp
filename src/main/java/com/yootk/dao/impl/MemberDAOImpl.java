package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Set;

@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
    @Override
    public boolean doCreate(Member member) throws SQLException {
        String sql ="insert into member(mid,lid,did,name,sal,phone,note,regdate,inmid,locked,type,email,photo,password) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,member.getMid());
        super.pstmt.setLong(2,member.getLid());
        super.pstmt.setLong(3,member.getDid());
        super.pstmt.setString(4,member.getName());
        if(member.getSal() == null){
            super.pstmt.setDouble(5,Types.NULL);
        }else{
            super.pstmt.setDouble(5,member.getSal());
        }
        super.pstmt.setString(6,member.getPhone());
        super.pstmt.setString(7,member.getNote());
        super.pstmt.setDate(8,new java.sql.Date(new java.util.Date().getTime()));
        super.pstmt.setString(9,member.getInmid());
        if(member.getLocked() == null){
            super.pstmt.setInt(10,Types.NULL);
        }else{
            super.pstmt.setInt(10,member.getLocked());
        }
        if(member.getType() == null){
            super.pstmt.setInt(11,Types.NULL);
        }else{
            super.pstmt.setInt(11,member.getType());
        }

        super.pstmt.setString(12,member.getEmail());
        super.pstmt.setString(13,member.getPhoto());
        super.pstmt.setString(14,member.getPassword());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Member member) throws SQLException {
        String sql ="update member set lid=?,did=?,name=?,sal=?,phone=?,note=?,inmid=?,type=?,email=?,photo=?,password=? where mid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,member.getLid());
        super.pstmt.setLong(2,member.getDid());
        super.pstmt.setString(3,member.getName());
        if(member.getSal() == null){
            super.pstmt.setDouble(4,Types.NULL);
        }else{
            super.pstmt.setDouble(4,member.getSal());
        }
        super.pstmt.setString(5,member.getPhone());
        super.pstmt.setString(6,member.getNote());
        super.pstmt.setString(7,member.getInmid());
        if(member.getType() == null){
            super.pstmt.setInt(8,Types.NULL);
        }else{
            super.pstmt.setInt(8,member.getType());
        }
        super.pstmt.setString(9,member.getEmail());
        super.pstmt.setString(10,member.getPhoto());
        super.pstmt.setString(11,member.getPassword());
        super.pstmt.setString(12,member.getMid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {

        String sql = "update member set locked = ? where mid = ?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        System.out.println(sql);
        for(String str:strings){
            super.pstmt.setInt(1,1);
            super.pstmt.setString(2,str);
            super.pstmt.addBatch();
        }
        System.out.println("======================================");
        return  super.isBatchSuccess( super.pstmt.executeBatch());
    }

    @Override
    public Member findById(String mid) throws SQLException {

        String sql = "select mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid from member where mid=?";
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Member.class);
    }

    @Override
    public List<Member> findAll() throws SQLException {
        String sql = "select mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid from member ";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Member.class);
    }
    @Override
    public List<Member> findAllMap() throws SQLException {
        String sql = "select mid,name from member ";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Member.class);
    }
    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql ="select mid,lid,did,sal,name,type,phone,photo,note,regdate,inmid,locked,email from member where locked = 0   LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs, Member.class);
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql ="select mid,lid,did,sal,name,type,phone,photo,note,regdate,inmid,locked,email from member where  locked = 0  and "+column+"  like ?  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs, Member.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        String sql = "select count(*) from member where locked = 0  " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        if(rs.next()){
            return rs.getLong(1) ;
        }
        return 0L;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(*) from member where locked = 0  and '" +column+ "' like ? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        if(rs.next()){
            return rs.getLong(1) ;
        }
        return 0L;
    }

    @Override
    public Long findDidByDeptAndMember(String mid) throws SQLException {
        String sql = "SELECT did FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public boolean doEditPasswordByMember(String newpassword,String mid) throws SQLException {
        String sql = "UPDATE member SET password=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,newpassword);
        super.pstmt.setString(2,mid);
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEditDatumByMember(Member vo) throws SQLException {
        String sql = "UPDATE member SET name=?,phone=?,email=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getName());
        super.pstmt.setString(2,vo.getPhone());
        super.pstmt.setString(3,vo.getEmail());
        super.pstmt.setString(4,vo.getMid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public Member findDatumByMember(String mid) throws SQLException {
        Member vo = null;
        String sql = "SELECT name,phone,email FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Member();
            vo.setName(rs.getString(1));
            vo.setPhone(rs.getString(2));
            vo.setEmail(rs.getString(3));
        }
        return vo;
    }

    @Override
    public String findMemberById(String mid) throws SQLException {
        String sql = "SELECT mid FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public Integer findTypeByMember(String mid) throws SQLException {
        String sql = "SELECT type FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doCreateByMember(Member vo) throws SQLException {
        String sql = "INSERT INTO member(mid,name,password) VALUES (?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getName());
        super.pstmt.setString(3, vo.getPassword());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public Member findByIdAndpw(String id) throws SQLException {
        Member vo = null;
        String sql = "SELECT mid,name,password FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setPassword(rs.getString(3));
            return vo;
        }
        return vo;
    }
    @Override
    public List<Member> findByDept(Long did) throws SQLException {
        String sql = "select mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid from member where did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, did);
        return super.handleResultToList(super.pstmt.executeQuery(), Member.class);
    }
}

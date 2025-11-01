Attribute VB_Name = "Poto"
Option Explicit
Type pack
    scode As Variant
    sdate As Variant
    stime As Variant
    row As Variant
    row2 As Variant
    col As Variant
End Type

Global r1 As New ADODB.Recordset
Global r2 As New ADODB.Recordset
Global conn As New ADODB.Connection
Global cmd As New ADODB.Command
Global retdata, detdata, sscode
Global movname, param(2)
Global rpack(10) As pack
Global fromarray(10) As Integer
Global toarray(10) As Integer
Global mcount(10) As Integer
Global nclient As Integer


Function Enquirytable(epack As pack)
Dim sql

    sql = "select set1,set2,set3,set4,set5,set6,set7,set8,set9 from ticket1 where m_code= ? and sdate= ? and stime=?"
    cmd.CommandText = sql
    
    param(0) = epack.scode
    param(1) = epack.sdate
    param(2) = epack.stime
    
    Set r1 = cmd.Execute(, param)
    r1.MoveFirst
    retdata = r1.GetRows(10)

End Function

Function Updatetable(upack As pack)
Dim sql1

    sql1 = "update ticket1 set set" & upack.row & " = -1 where m_code =" & upack.scode & "and sdate=#" & upack.sdate & "# and stime=#" & upack.stime & "# and r_code='" & upack.col & "'"
   
    cmd.CommandText = sql1
    Set r1 = cmd.Execute
    
End Function
Function Marktable(mpack As pack)
Dim sql1

    sql1 = "update ticket1 set set" & mpack.row & " = -2 where m_code =" & mpack.scode & "and sdate=#" & mpack.sdate & "# and stime=#" & mpack.stime & "# and r_code='" & mpack.col & "'"
    
    cmd.CommandText = sql1
    Set r1 = cmd.Execute
    
End Function

Function Restable(spack As pack)
Dim sql1
Dim i As Integer
    
    For i = spack.row To spack.row2
        sql1 = "update ticket1 set set" & i & " = 0 where m_code =" & spack.scode & "and sdate=#" & spack.sdate & "# and stime=#" & spack.stime & "# and r_code='" & spack.col & "'"

        cmd.CommandText = sql1
        Set r1 = cmd.Execute
    Next i
    
End Function
Function Detecttable(dpack As pack) As Integer
Dim sql
Dim i As Integer

    sql = "select set1,set2,set3,set4,set5,set6,set7,set8,set9 from ticket1 where m_code =" & dpack.scode & "and sdate=#" & dpack.sdate & "# and stime=#" & dpack.stime & "# and r_code='" & dpack.col & "'"

    cmd.CommandText = sql
    Set r1 = cmd.Execute
    r1.MoveFirst
    Detecttable = r1.Fields(dpack.row - 1) * -2
    Exit Function
    
End Function

Sub OpenDB()
Dim connstr As String

    connstr = "provider=microsoft.jet.oledb.3.51;" & _
            "data source=c:\project\acdb\poto.mdb"
            
    conn.Open connstr
    Set cmd.ActiveConnection = conn
    r1.CursorLocation = adUseClient

End Sub

Sub CloseDB()

    conn.Close
    Set conn = Nothing
    
End Sub



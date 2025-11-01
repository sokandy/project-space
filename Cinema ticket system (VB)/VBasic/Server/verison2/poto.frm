VERSION 5.00
Object = "{33101C00-75C3-11CF-A8A0-444553540000}#1.0#0"; "CSWSK32.OCX"
Begin VB.Form Form1 
   BackColor       =   &H00FFFF80&
   Caption         =   "Form1"
   ClientHeight    =   5736
   ClientLeft      =   132
   ClientTop       =   420
   ClientWidth     =   6888
   LinkTopic       =   "Form1"
   ScaleHeight     =   5736
   ScaleWidth      =   6888
   StartUpPosition =   2  '¿Ã¹õ¤¤¥¡
   Begin SocketWrenchCtrl.Socket Socket2 
      Index           =   0
      Left            =   6240
      Top             =   600
      _Version        =   65536
      _ExtentX        =   593
      _ExtentY        =   593
      _StockProps     =   0
      AutoResolve     =   -1  'True
      Backlog         =   5
      Binary          =   -1  'True
      Blocking        =   -1  'True
      Broadcast       =   0   'False
      BufferSize      =   0
      HostAddress     =   ""
      HostFile        =   ""
      HostName        =   ""
      InLine          =   0   'False
      Interval        =   0
      KeepAlive       =   0   'False
      Library         =   ""
      Linger          =   0
      LocalPort       =   0
      LocalService    =   ""
      Protocol        =   0
      RemotePort      =   0
      RemoteService   =   ""
      ReuseAddress    =   0   'False
      Route           =   -1  'True
      Timeout         =   0
      Type            =   1
      Urgent          =   0   'False
   End
   Begin VB.CommandButton Command3 
      Caption         =   "Close Of Branch"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   13.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   972
      Left            =   4320
      TabIndex        =   10
      Top             =   3480
      Width           =   1812
   End
   Begin VB.CommandButton Command2 
      Caption         =   "Print Daily Report"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   13.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   972
      Left            =   2280
      TabIndex        =   9
      Top             =   3480
      Width           =   1812
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Cinema Online Status"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   13.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   972
      Left            =   240
      TabIndex        =   8
      Top             =   3480
      Width           =   1812
   End
   Begin VB.TextBox Text3 
      Enabled         =   0   'False
      Height          =   264
      Left            =   1920
      TabIndex        =   6
      Top             =   2520
      Width           =   972
   End
   Begin VB.Timer Timer1 
      Interval        =   1
      Left            =   6240
      Top             =   1080
   End
   Begin VB.TextBox Text2 
      Enabled         =   0   'False
      Height          =   264
      Left            =   1920
      TabIndex        =   4
      Top             =   2040
      Width           =   972
   End
   Begin VB.TextBox Text1 
      Enabled         =   0   'False
      Height          =   264
      Left            =   5160
      TabIndex        =   2
      Top             =   2040
      Width           =   612
   End
   Begin VB.Label Label5 
      Alignment       =   2  '¸m¤¤¹ï»ô
      Caption         =   "Server Online Manual"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   13.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   492
      Left            =   1800
      TabIndex        =   7
      Top             =   1440
      Width           =   2892
   End
   Begin VB.Label Label4 
      Alignment       =   1  '¾a¥k¹ï»ô
      BackColor       =   &H00FFFF80&
      Caption         =   "Time :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   252
      Left            =   360
      TabIndex        =   5
      Top             =   2520
      Width           =   1212
   End
   Begin VB.Label Label3 
      Alignment       =   1  '¾a¥k¹ï»ô
      BackColor       =   &H00FFFF80&
      Caption         =   "Business Day :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   252
      Left            =   360
      TabIndex        =   3
      Top             =   2040
      Width           =   1212
   End
   Begin VB.Label Label2 
      BackColor       =   &H00FFFF80&
      Caption         =   "No of Client Login :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   252
      Left            =   3480
      TabIndex        =   1
      Top             =   2040
      Width           =   1572
   End
   Begin VB.Label Label1 
      Alignment       =   2  '¸m¤¤¹ï»ô
      BackColor       =   &H00FFFF80&
      Caption         =   "Centralized Cinema Ticket Booking System"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   25.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   1212
      Left            =   120
      TabIndex        =   0
      Top             =   120
      Width           =   5772
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim LastSocket As Integer
Dim sum As Integer

Private Sub Command1_Click()
    Form2.Show
End Sub

Private Sub Command2_Click()
    Form3.Show
End Sub

Private Sub Command3_Click()
    If Text1.Text <> 0 Then
        MsgBox "Some Connection Established! Data will be lost, Try Later!", vbInformation, "CLOSE OF BRANCH"
    Else
        Unload Me
    End If
    
End Sub

Private Sub Form_Load()
    
    Socket2(0).AddressFamily = AF_INET
    Socket2(0).Protocol = IPPROTO_IP
    Socket2(0).SocketType = SOCK_STREAM
    Socket2(0).Blocking = False
    Socket2(0).LocalPort = IPPORT_ECHO
    Socket2(0).Listen
    LastSocket = 0
    nclient = 0
    Text1.Text = nclient
    Text2.Text = "23/12/1999"
    OpenDB
End Sub
Private Sub Form_Unload(Cancel As Integer)
    Dim i As Integer
    
    If Socket2(0).Listening Then Socket2(0).Disconnect
    For i = 1 To LastSocket
        If Socket2(i).Connected Then Socket2(i).Disconnect
    Next i
    
    CloseDB
End Sub

Private Sub Label10_Click()

End Sub

Private Sub Socket2_Disconnect(Index As Integer)
    Socket2(Index).Disconnect
    nclient = nclient - 1
    Text1.Text = nclient
End Sub
Private Sub Socket2_Accept(Index As Integer, SocketId As Integer)
    Dim i As Integer

    For i = 1 To LastSocket
        If Not Socket2(i).Connected Then Exit For
    Next i
    
    If i > LastSocket Then
        LastSocket = LastSocket + 1: i = LastSocket
        Load Socket2(i)
    End If

    Socket2(i).AddressFamily = AF_INET
    Socket2(i).Protocol = IPPROTO_IP
    Socket2(i).SocketType = SOCK_STREAM
    Socket2(i).Binary = True
    Socket2(i).BufferSize = 1024
    Socket2(i).Blocking = False
    Socket2(i).Accept = SocketId
    
    nclient = nclient + 1
    Text1.Text = nclient
End Sub
Private Sub Socket2_Read(Index As Integer, DataLength As Integer, IsUrgent As Integer)
    Dim sbuffer As String
    Dim fun As String
    Dim j, k As Integer
    
    
    
    Socket2(Index).Read sbuffer, DataLength
    mcount(Index) = 0
    
    fun = Mid$(sbuffer, 1, 3)
    rpack(Index).scode = Val(Mid$(sbuffer, 4, 1))
    rpack(Index).sdate = (Mid$(sbuffer, 5, 8))
    rpack(Index).stime = (Mid$(sbuffer, 13, 5))
    rpack(Index).col = Mid$(sbuffer, 18, 1)
    rpack(Index).row = Val(Mid$(sbuffer, 19, 1))
    rpack(Index).row2 = Val(Mid$(sbuffer, 20, 1))

    sbuffer = ""
    
    If fun = "con" Then
        fromarray(Index) = rpack(Index).row
        toarray(Index) = rpack(Index).row2
        
        For j = fromarray(Index) To toarray(Index)
            
            rpack(Index).row = j
            If (Detecttable(rpack(Index)) = 4) Then
                Updatetable rpack(Index)
                sbuffer = "CKThank You! Take the Tickets!"
            Else
                sbuffer = "CKConfirm Error, Call Your Support!"
                Exit For
            End If
            
        Next j
    End If
        
    If fun = "rej" Then
            Restable rpack(Index)
            sbuffer = "CKAttention!                  Last Process Not Complete!"
    End If
    
    If fun = "buy" Then
    
        fromarray(Index) = rpack(Index).row
        toarray(Index) = rpack(Index).row2
        
        For j = fromarray(Index) To toarray(Index)
            
            rpack(Index).row = j
            If (Detecttable(rpack(Index)) <> 0) Then
                sbuffer = "NKBuy Error, Try Again!"
                If (mcount(Index) > 0) Then
                    rpack(Index).row = fromarray(Index)
                    rpack(Index).row2 = fromarray(Index) + mcount(Index) - 1
                    Restable rpack(Index)
                End If
                Exit For
            Else
                Marktable rpack(Index)
                mcount(Index) = mcount(Index) + 1
                sbuffer = "OKBuy " & mcount(Index) & " Tickets is " & mcount(Index) * 50 & " dollar! Pls Confirm this Process Thank You !"
            End If
            
        Next j
        
    End If
    
    If fun = "enq" Then
        sum = 0
        Enquirytable rpack(Index)
        sbuffer = "EK"
        For j = 0 To 9
            For k = 0 To 8
                If (retdata(k, j) = 0) Then
                    sum = sum + 1
                End If
                sbuffer = sbuffer & (retdata(k, j) * -2)
            Next k
        Next j
        'Label11.Caption = sum
    End If

    Socket2(Index).Write sbuffer, Len(sbuffer)
End Sub

Private Sub Timer1_Timer()
    Text3.Text = Time()
End Sub

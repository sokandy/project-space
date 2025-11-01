VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00FFFF80&
   Caption         =   "Form2"
   ClientHeight    =   5736
   ClientLeft      =   48
   ClientTop       =   336
   ClientWidth     =   6888
   LinkTopic       =   "Form2"
   ScaleHeight     =   5736
   ScaleWidth      =   6888
   StartUpPosition =   2  '螢幕中央
   Begin VB.CommandButton Command2 
      Caption         =   "O.K."
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   852
      Left            =   4200
      TabIndex        =   24
      Top             =   1200
      Width           =   972
   End
   Begin VB.TextBox Text2 
      Height          =   264
      Index           =   2
      Left            =   5520
      TabIndex        =   17
      Top             =   4320
      Width           =   612
   End
   Begin VB.TextBox Text1 
      Height          =   264
      Index           =   2
      Left            =   4560
      TabIndex        =   16
      Top             =   4320
      Width           =   612
   End
   Begin VB.TextBox Text2 
      Height          =   264
      Index           =   1
      Left            =   3360
      TabIndex        =   13
      Top             =   4320
      Width           =   612
   End
   Begin VB.TextBox Text1 
      Height          =   264
      Index           =   1
      Left            =   2400
      TabIndex        =   12
      Top             =   4320
      Width           =   612
   End
   Begin VB.TextBox Text2 
      Height          =   264
      Index           =   0
      Left            =   1080
      TabIndex        =   9
      Top             =   4320
      Width           =   612
   End
   Begin VB.TextBox Text1 
      Height          =   264
      Index           =   0
      Left            =   240
      TabIndex        =   8
      Top             =   4320
      Width           =   612
   End
   Begin VB.ComboBox Combo2 
      BeginProperty DataFormat 
         Type            =   1
         Format          =   "h:nn AM/PM"
         HaveTrueFalseNull=   0
         FirstDayOfWeek  =   0
         FirstWeekOfYear =   0
         LCID            =   1028
         SubFormatType   =   4
      EndProperty
      Height          =   276
      ItemData        =   "Form2.frx":0000
      Left            =   2040
      List            =   "Form2.frx":0013
      TabIndex        =   5
      Text            =   "Combo2"
      Top             =   1800
      Width           =   1215
   End
   Begin VB.ComboBox Combo1 
      BeginProperty DataFormat 
         Type            =   1
         Format          =   "d/M/yyyy"
         HaveTrueFalseNull=   0
         FirstDayOfWeek  =   0
         FirstWeekOfYear =   0
         LCID            =   1028
         SubFormatType   =   3
      EndProperty
      Height          =   276
      ItemData        =   "Form2.frx":003A
      Left            =   2040
      List            =   "Form2.frx":0047
      TabIndex        =   4
      Text            =   "Combo1"
      Top             =   1200
      Width           =   1215
   End
   Begin VB.CommandButton Command1 
      Caption         =   "Back"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   492
      Left            =   2520
      TabIndex        =   0
      Top             =   4920
      Width           =   1452
   End
   Begin VB.Line Line12 
      X1              =   6360
      X2              =   6360
      Y1              =   2880
      Y2              =   4680
   End
   Begin VB.Line Line11 
      X1              =   4440
      X2              =   6360
      Y1              =   2880
      Y2              =   2880
   End
   Begin VB.Line Line10 
      X1              =   4440
      X2              =   6360
      Y1              =   4680
      Y2              =   4680
   End
   Begin VB.Line Line9 
      X1              =   4440
      X2              =   4440
      Y1              =   2880
      Y2              =   4680
   End
   Begin VB.Line Line8 
      X1              =   4200
      X2              =   4200
      Y1              =   2880
      Y2              =   4680
   End
   Begin VB.Line Line7 
      X1              =   2280
      X2              =   4200
      Y1              =   2880
      Y2              =   2880
   End
   Begin VB.Line Line6 
      X1              =   2280
      X2              =   4200
      Y1              =   4680
      Y2              =   4680
   End
   Begin VB.Line Line5 
      X1              =   2280
      X2              =   2280
      Y1              =   2880
      Y2              =   4680
   End
   Begin VB.Line Line4 
      X1              =   2040
      X2              =   2040
      Y1              =   2880
      Y2              =   4680
   End
   Begin VB.Line Line3 
      X1              =   120
      X2              =   2040
      Y1              =   2880
      Y2              =   2880
   End
   Begin VB.Line Line2 
      X1              =   120
      X2              =   2040
      Y1              =   4680
      Y2              =   4680
   End
   Begin VB.Line Line1 
      X1              =   120
      X2              =   120
      Y1              =   2880
      Y2              =   4680
   End
   Begin VB.Label Label15 
      Alignment       =   2  '置中對齊
      Caption         =   "Cinema B"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   19.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   492
      Left            =   2280
      TabIndex        =   23
      Top             =   2400
      Width           =   1932
   End
   Begin VB.Label Label14 
      Alignment       =   2  '置中對齊
      Caption         =   "Cinema C"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   19.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   492
      Left            =   4440
      TabIndex        =   22
      Top             =   2400
      Width           =   1932
   End
   Begin VB.Label Label13 
      Alignment       =   2  '置中對齊
      Caption         =   "Cinema A"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   19.8
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   492
      Left            =   120
      TabIndex        =   21
      Top             =   2400
      Width           =   1932
   End
   Begin VB.Label Label12 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Online Status Manual"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   24
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   732
      Left            =   120
      TabIndex        =   20
      Top             =   120
      Width           =   6612
   End
   Begin VB.Label Label11 
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
      Left            =   1320
      TabIndex        =   19
      Top             =   1800
      Width           =   612
   End
   Begin VB.Label Label10 
      BackColor       =   &H00FFFF80&
      Caption         =   "Date :"
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
      Left            =   1320
      TabIndex        =   18
      Top             =   1200
      Width           =   612
   End
   Begin VB.Label Label9 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Not avaible"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   372
      Left            =   5400
      TabIndex        =   15
      Top             =   3840
      Width           =   852
   End
   Begin VB.Label Label8 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Avaible"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   372
      Left            =   4560
      TabIndex        =   14
      Top             =   3840
      Width           =   612
   End
   Begin VB.Label Label7 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Not avaible"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   372
      Left            =   3240
      TabIndex        =   11
      Top             =   3840
      Width           =   852
   End
   Begin VB.Label Label6 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Avaible"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   372
      Left            =   2400
      TabIndex        =   10
      Top             =   3840
      Width           =   612
   End
   Begin VB.Label Label5 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Not avaible"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   372
      Left            =   1080
      TabIndex        =   7
      Top             =   3840
      Width           =   732
   End
   Begin VB.Label Label4 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Avaible"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   372
      Left            =   240
      TabIndex        =   6
      Top             =   3840
      Width           =   612
   End
   Begin VB.Label Label3 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Star War"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   16.2
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   732
      Left            =   2280
      TabIndex        =   3
      Top             =   3000
      Width           =   1932
   End
   Begin VB.Label Label2 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Broken Arrow"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   16.2
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   732
      Left            =   4440
      TabIndex        =   2
      Top             =   3000
      Width           =   1932
   End
   Begin VB.Label Label1 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFFF80&
      Caption         =   "Super Man"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   16.2
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   732
      Left            =   120
      TabIndex        =   1
      Top             =   3000
      Width           =   1932
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim serpack(2) As pack
Dim sersum(2) As Integer

Private Sub Command1_click()
    Unload Me
End Sub

Private Sub SER_ENQ()
Dim i, j, k As Integer

    For i = 0 To 2
        sersum(i) = 0
        serpack(i).sdate = Combo1.Text
        serpack(i).stime = Combo2.Text
        Enquirytable serpack(i)
        detdata = retdata
        For j = 0 To 9
            For k = 0 To 8
                If (detdata(k, j) = 0) Then
                    sersum(i) = sersum(i) + 1
                End If
            Next k
        Next j
        Text1(i).Text = sersum(i)
        Text2(i).Text = 90 - sersum(i)
    Next i
    
End Sub

Private Sub Command2_Click()
    SER_ENQ
End Sub

Private Sub Form_Load()

    Combo1.ListIndex = 0
    Combo2.ListIndex = 0
    serpack(0).scode = 1
    serpack(1).scode = 2
    serpack(2).scode = 3
    SER_ENQ
    
End Sub

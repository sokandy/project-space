VERSION 5.00
Begin VB.Form Form2 
   BackColor       =   &H00FFFF80&
   Caption         =   "Form2"
   ClientHeight    =   4245
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   6735
   LinkTopic       =   "Form2"
   ScaleHeight     =   4245
   ScaleWidth      =   6735
   StartUpPosition =   1  'CenterOwner
   Begin VB.CommandButton Command3 
      BackColor       =   &H00FFFFC0&
      Caption         =   "     Cinema C Broken Arrow"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   3255
      Left            =   4560
      Style           =   1  'Graphical
      TabIndex        =   2
      Top             =   840
      Width           =   1935
   End
   Begin VB.CommandButton Command2 
      BackColor       =   &H00FFFFC0&
      Caption         =   "Cinema B Star War"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   3255
      Left            =   2400
      MaskColor       =   &H00FFFFC0&
      Style           =   1  'Graphical
      TabIndex        =   1
      Top             =   840
      Width           =   1935
   End
   Begin VB.CommandButton Command1 
      BackColor       =   &H00FFFFC0&
      Caption         =   "Cinema A Superman"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   3255
      Left            =   240
      MaskColor       =   &H00FF0000&
      Style           =   1  'Graphical
      TabIndex        =   0
      Top             =   840
      Width           =   1935
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00FFFF00&
      Caption         =   "TsimShaTsui Booking Centre "
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   24
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FF0000&
      Height          =   615
      Left            =   120
      TabIndex        =   3
      Top             =   120
      Width           =   6495
   End
End
Attribute VB_Name = "Form2"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Command1_Click()
    sscode = 1
    movname = "Super Man"
    Form1.Show
    
End Sub

Private Sub Command2_Click()
    sscode = 2
    movname = "Star War"
    Form1.Show
End Sub

Private Sub Command3_Click()
    sscode = 3
    movname = "Broken Arrow"
    Form1.Show
End Sub


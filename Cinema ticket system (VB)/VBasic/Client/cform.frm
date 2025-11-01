VERSION 5.00
Object = "{33101C00-75C3-11CF-A8A0-444553540000}#1.0#0"; "CSWSK32.OCX"
Begin VB.Form Form1 
   BackColor       =   &H00FFC0C0&
   Caption         =   "Form1"
   ClientHeight    =   5292
   ClientLeft      =   48
   ClientTop       =   420
   ClientWidth     =   7512
   ForeColor       =   &H00FFFF80&
   LinkTopic       =   "Form1"
   ScaleHeight     =   5292
   ScaleWidth      =   7512
   StartUpPosition =   2  '螢幕中央
   Begin SocketWrenchCtrl.Socket Socket1 
      Left            =   5280
      Top             =   840
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
   Begin VB.CommandButton Reject 
      BackColor       =   &H00C0C000&
      Caption         =   "Reject"
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
      Left            =   6240
      Style           =   1  '圖片外觀
      TabIndex        =   133
      Top             =   4320
      Visible         =   0   'False
      Width           =   972
   End
   Begin VB.ComboBox tr2 
      Height          =   315
      ItemData        =   "cform.frx":0000
      Left            =   3840
      List            =   "cform.frx":001F
      TabIndex        =   131
      Text            =   "Combo4"
      Top             =   4680
      Width           =   735
   End
   Begin VB.ComboBox tr1 
      Enabled         =   0   'False
      Height          =   315
      Left            =   3120
      TabIndex        =   130
      Text            =   "Combo1"
      Top             =   4680
      Width           =   735
   End
   Begin VB.ComboBox fr2 
      Height          =   315
      ItemData        =   "cform.frx":003E
      Left            =   1560
      List            =   "cform.frx":005D
      TabIndex        =   129
      Text            =   "Combo1"
      Top             =   4680
      Width           =   735
   End
   Begin VB.ComboBox fr1 
      Height          =   315
      ItemData        =   "cform.frx":007C
      Left            =   840
      List            =   "cform.frx":009E
      TabIndex        =   128
      Text            =   "Combo1"
      Top             =   4680
      Width           =   735
   End
   Begin VB.CommandButton Manual 
      BackColor       =   &H00FFFFC0&
      Caption         =   "Sub Manual"
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
      Left            =   2880
      Style           =   1  '圖片外觀
      TabIndex        =   126
      Top             =   3720
      Width           =   2055
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   89
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   125
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   88
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   124
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   87
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   123
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   86
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   122
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   85
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   121
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   84
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   120
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   83
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   119
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   82
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   118
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   81
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   117
      Top             =   3240
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   80
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   116
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   79
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   115
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   78
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   114
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   77
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   113
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   76
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   112
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   75
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   111
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   74
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   110
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   73
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   109
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   72
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   108
      Top             =   3000
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   71
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   107
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   70
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   106
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   69
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   105
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   68
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   104
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   67
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   103
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   66
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   102
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   65
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   101
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   64
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   100
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   63
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   99
      Top             =   2760
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   62
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   98
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   61
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   97
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   60
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   96
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   59
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   95
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   58
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   94
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   57
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   93
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   56
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   92
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   55
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   91
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   54
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   90
      Top             =   2520
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   53
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   89
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   52
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   88
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   51
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   87
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   50
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   86
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   49
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   85
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   48
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   84
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   47
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   83
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   46
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   82
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   45
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   81
      Top             =   2280
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   44
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   80
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   43
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   79
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   42
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   78
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   41
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   77
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   40
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   76
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   39
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   75
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   38
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   74
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   37
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   73
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   36
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   72
      Top             =   2040
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   35
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   71
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   34
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   70
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   33
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   69
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   32
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   68
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   31
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   67
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   30
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   66
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   29
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   65
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   28
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   64
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   27
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   63
      Top             =   1800
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   26
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   62
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   25
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   61
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   24
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   60
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   23
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   59
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   22
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   58
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   21
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   57
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   20
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   56
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   19
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   55
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   18
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   54
      Top             =   1560
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   17
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   53
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   16
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   52
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   15
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   51
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   14
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   50
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   13
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   49
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   12
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   48
      Top             =   1320
      Width           =   255
   End
   Begin VB.CommandButton Buy 
      BackColor       =   &H00C0C000&
      Caption         =   "Buy"
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
      Left            =   5160
      Style           =   1  '圖片外觀
      TabIndex        =   19
      Top             =   4320
      Width           =   972
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   1
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   17
      Top             =   1080
      Width           =   255
   End
   Begin VB.CommandButton Home 
      BackColor       =   &H00FFFFC0&
      Caption         =   "Home"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   1560
      Style           =   1  '圖片外觀
      TabIndex        =   16
      Top             =   3720
      Width           =   1215
   End
   Begin VB.CommandButton Enquiry 
      BackColor       =   &H00FFFFC0&
      Caption         =   "Enquiry"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   240
      Style           =   1  '圖片外觀
      TabIndex        =   15
      Top             =   3720
      Width           =   1215
   End
   Begin VB.ComboBox Combo3 
      BeginProperty DataFormat 
         Type            =   1
         Format          =   "h:nn AM/PM"
         HaveTrueFalseNull=   0
         FirstDayOfWeek  =   0
         FirstWeekOfYear =   0
         LCID            =   1028
         SubFormatType   =   4
      EndProperty
      Height          =   315
      ItemData        =   "cform.frx":00C0
      Left            =   6120
      List            =   "cform.frx":00D3
      TabIndex        =   14
      Text            =   "Combo3"
      Top             =   480
      Width           =   1215
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   11
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   12
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   10
      Left            =   1080
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   11
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   9
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   10
      Top             =   1320
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   8
      Left            =   3960
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   9
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   7
      Left            =   3600
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   8
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   6
      Left            =   3240
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   7
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   5
      Left            =   2880
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   6
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   4
      Left            =   2160
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   5
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   3
      Left            =   1800
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   4
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   2
      Left            =   1440
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   3
      Top             =   1080
      Width           =   255
   End
   Begin VB.CheckBox Check1 
      BackColor       =   &H00FFC0C0&
      Height          =   255
      Index           =   0
      Left            =   720
      MaskColor       =   &H00FFFFFF&
      TabIndex        =   2
      Top             =   1080
      Width           =   255
   End
   Begin VB.ComboBox Combo2 
      BeginProperty DataFormat 
         Type            =   1
         Format          =   "d/M/yyyy"
         HaveTrueFalseNull=   0
         FirstDayOfWeek  =   0
         FirstWeekOfYear =   0
         LCID            =   1028
         SubFormatType   =   3
      EndProperty
      Height          =   315
      ItemData        =   "cform.frx":00FA
      Left            =   6120
      List            =   "cform.frx":0107
      TabIndex        =   1
      Text            =   "Combo2"
      Top             =   120
      Width           =   1215
   End
   Begin VB.CommandButton Connect 
      BackColor       =   &H00FFFFC0&
      Caption         =   "Connect"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   9.6
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   2880
      Style           =   1  '圖片外觀
      TabIndex        =   0
      Top             =   3720
      Visible         =   0   'False
      Width           =   1215
   End
   Begin VB.Label Label3 
      BackColor       =   &H00FFC0C0&
      Caption         =   "Message Area"
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
      Left            =   5280
      TabIndex        =   135
      Top             =   1404
      Width           =   1212
   End
   Begin VB.Label mbox 
      BackColor       =   &H00C0C0FF&
      BorderStyle     =   1  '單線固定
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   10.2
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00400000&
      Height          =   1692
      Left            =   5280
      TabIndex        =   134
      Top             =   1680
      Width           =   2052
   End
   Begin VB.Label Label2 
      Alignment       =   1  '靠右對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "To:"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   2400
      TabIndex        =   132
      Top             =   4680
      Width           =   615
   End
   Begin VB.Label Label1 
      BackColor       =   &H00FFC0C0&
      Caption         =   "From:"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   120
      TabIndex        =   127
      Top             =   4680
      Width           =   615
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "9"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   8
      Left            =   3960
      TabIndex        =   47
      Top             =   840
      Width           =   255
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "8"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   7
      Left            =   3600
      TabIndex        =   46
      Top             =   840
      Width           =   255
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "7"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   6
      Left            =   3240
      TabIndex        =   45
      Top             =   840
      Width           =   255
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "6"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   5
      Left            =   2880
      TabIndex        =   44
      Top             =   840
      Width           =   255
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "E"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   7
      Left            =   4440
      TabIndex        =   43
      Top             =   120
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "X"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   6
      Left            =   4440
      TabIndex        =   42
      Top             =   360
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "I"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   5
      Left            =   4440
      TabIndex        =   41
      Top             =   600
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "T"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   4
      Left            =   4440
      TabIndex        =   40
      Top             =   840
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "T"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   3
      Left            =   240
      TabIndex        =   39
      Top             =   840
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "I"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   2
      Left            =   240
      TabIndex        =   38
      Top             =   600
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "X"
      ForeColor       =   &H000000FF&
      Height          =   255
      Index           =   1
      Left            =   240
      TabIndex        =   37
      Top             =   360
      Width           =   135
   End
   Begin VB.Label exit 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "E"
      ForeColor       =   &H000000FF&
      Height          =   375
      Index           =   0
      Left            =   240
      TabIndex        =   36
      Top             =   120
      Width           =   135
   End
   Begin VB.Shape Shape2 
      BackColor       =   &H8000000E&
      FillStyle       =   0  '實心
      Height          =   135
      Left            =   0
      Top             =   3480
      Width           =   5055
   End
   Begin VB.Shape Shape1 
      FillStyle       =   0  '實心
      Height          =   3735
      Left            =   4920
      Top             =   -120
      Width           =   135
   End
   Begin VB.Label collabel 
      Alignment       =   1  '靠右對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "5"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   4
      Left            =   2160
      TabIndex        =   35
      Top             =   840
      Width           =   135
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "4"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   3
      Left            =   1800
      TabIndex        =   34
      Top             =   840
      Width           =   255
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "3"
      Enabled         =   0   'False
      ForeColor       =   &H00404040&
      Height          =   255
      Index           =   2
      Left            =   1440
      TabIndex        =   33
      Top             =   840
      Width           =   135
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "2"
      Enabled         =   0   'False
      ForeColor       =   &H00000000&
      Height          =   255
      Index           =   1
      Left            =   1080
      TabIndex        =   32
      Top             =   840
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "J"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   9
      Left            =   480
      TabIndex        =   31
      Top             =   3240
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "I"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   8
      Left            =   480
      TabIndex        =   30
      Top             =   3000
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "H"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   7
      Left            =   480
      TabIndex        =   29
      Top             =   2760
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "G"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   6
      Left            =   480
      TabIndex        =   28
      Top             =   2520
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "F"
      ForeColor       =   &H00FF0000&
      Height          =   375
      Index           =   5
      Left            =   480
      TabIndex        =   27
      Top             =   2280
      Width           =   135
   End
   Begin VB.Label rowlabel 
      BackColor       =   &H00FFC0C0&
      Caption         =   "E"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   4
      Left            =   480
      TabIndex        =   26
      Top             =   2040
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "D"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   3
      Left            =   480
      TabIndex        =   25
      Top             =   1800
      Width           =   135
   End
   Begin VB.Label rowlabel 
      BackColor       =   &H00FFC0C0&
      Caption         =   "C"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   2
      Left            =   480
      TabIndex        =   24
      Top             =   1560
      Width           =   135
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "B"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   1
      Left            =   480
      TabIndex        =   23
      Top             =   1320
      Width           =   135
   End
   Begin VB.Label Label7 
      BackColor       =   &H00FFC0C0&
      Caption         =   "Time :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   5400
      TabIndex        =   22
      Top             =   480
      Width           =   735
   End
   Begin VB.Label Label6 
      BackColor       =   &H00FFC0C0&
      Caption         =   "Date :"
      BeginProperty Font 
         Name            =   "Times New Roman"
         Size            =   12
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   255
      Left            =   5400
      TabIndex        =   21
      Top             =   120
      Width           =   735
   End
   Begin VB.Label collabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "1"
      Enabled         =   0   'False
      ForeColor       =   &H00404040&
      Height          =   255
      Index           =   0
      Left            =   720
      TabIndex        =   20
      Top             =   840
      Width           =   135
   End
   Begin VB.Label Label4 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      BorderStyle     =   1  '單線固定
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
      Left            =   600
      TabIndex        =   18
      Top             =   120
      Width           =   3735
   End
   Begin VB.Label rowlabel 
      Alignment       =   2  '置中對齊
      BackColor       =   &H00FFC0C0&
      Caption         =   "A"
      ForeColor       =   &H00FF0000&
      Height          =   255
      Index           =   0
      Left            =   480
      TabIndex        =   13
      Top             =   1080
      Width           =   135
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim LastSocket As Integer
Const TSEAT = 92

Private Sub Form_Activate()
    enquiry_click
End Sub

Private Sub fr2_GotFocus()
    tr2.Clear
End Sub

Private Sub fr2_lostfocus()
Dim i As Integer
Dim s As String
        
    For i = fr2.ListIndex + 1 To 9
        tr2.AddItem i
    Next i
    tr2.ListIndex = 0
End Sub

Private Sub Manual_Click()
    If Manual.Caption = "Sub Manual" Then
        Form1.Height = 5700
        Manual.Caption = "Main Manual"
        Combo2.Enabled = False
        Combo3.Enabled = False
        Home.Enabled = False
        Enquiry.Enabled = False
    Else
        Form1.Height = 4650
        Manual.Caption = "Sub Manual"
        Combo2.Enabled = True
        Combo3.Enabled = True
        Home.Enabled = True
        Enquiry.Enabled = True
        mbox = ""
    End If
End Sub

Private Sub enquiry_click()
    Dim sbuffer As String
    
    sbuffer = "enq" & sscode & Combo2.Text & Combo3.Text & Space(3)
    Socket1.Write sbuffer, Len(sbuffer)
    
End Sub

Private Sub Buy_Click()
    
    Dim sbuffer As String
    
    If Buy.Caption = "Buy" Then
        sbuffer = "buy" & sscode & Combo2.Text & Combo3.Text & fr1.Text & fr2.Text & tr2.Text
    End If
    
    If Buy.Caption = "Confirm" Then
        sbuffer = "con" & sscode & Combo2.Text & Combo3.Text & fr1.Text & fr2.Text & tr2.Text
        Buy.Caption = "Buy"
        fr1.Enabled = True
        fr2.Enabled = True
        tr1.Enabled = True
        tr2.Enabled = True
        Manual.Enabled = True
    End If
        
    Socket1.Write sbuffer, Len(sbuffer)
    
End Sub

Private Sub fr1_Click()
    tr1.Text = fr1.Text
End Sub

Private Sub Home_Click()
    Unload Me
End Sub

Private Sub Form_Load()
    
    Label4.Caption = movname
    
    fr1.ListIndex = 0
    fr2.ListIndex = 0
    tr2.ListIndex = 0
    Combo2.ListIndex = 0
    Combo3.ListIndex = 0
    
    Socket1.AddressFamily = AF_INET
    Socket1.Protocol = IPPROTO_IP
    Socket1.SocketType = SOCK_STREAM
    Socket1.Binary = False
    Socket1.BufferSize = 1024
    Socket1.Blocking = False

    Connect_Click
    
    Form1.Height = 4650
End Sub

Private Sub Form_Unload(Cancel As Integer)
    If Socket1.Connected Then Socket1.Disconnect
End Sub

Private Sub Reject_Click()
Dim sbuffer As String

        sbuffer = "rej" & sscode & Combo2.Text & Combo3.Text & fr1.Text & fr2.Text & tr2.Text
        Socket1.Write sbuffer, Len(sbuffer)
        fr1.Enabled = True
        fr2.Enabled = True
        tr1.Enabled = True
        tr2.Enabled = True
        Manual.Enabled = True
End Sub

Private Sub Socket1_Read(DataLength As Integer, IsUrgent As Integer)
    Dim sbuffer As String
    Dim msg As String
    Dim i, beg, fin, amt As Integer
        
    Socket1.Read sbuffer, DataLength
    
    If (Mid$(sbuffer, 1, 2) = "CK") Then
        msg = Mid$(sbuffer, 3)
        mbox.Caption = msg
        mbox.ForeColor = &H400000
        Buy.Caption = "Buy"
        Reject.Visible = False
        enquiry_click
    End If
    
    If (Mid$(sbuffer, 1, 2) = "OK") Then
        amt = 0
        msg = Mid$(sbuffer, 3)
        Buy.Caption = "Confirm"
        Reject.Visible = True
        fr1.Enabled = False
        fr2.Enabled = False
        tr1.Enabled = False
        tr2.Enabled = False
        Manual.Enabled = False
        If fr1.Text = "A" Then
            beg = Val(fr2.Text) - 1
            fin = Val(tr2.Text) - 1
        Else
            beg = ((Asc(fr1.Text) - 65) * 8) + Val(fr2.Text) + ((Asc(fr1.Text) - 65)) - 1
            fin = ((Asc(fr1.Text) - 65) * 8) + Val(tr2.Text) + ((Asc(fr1.Text) - 65)) - 1
        End If
        For i = beg To fin
            Check1(i) = 1
            amt = amt + 1
        Next i
        mbox.Caption = "You Buy " & fr1.Text & fr2.Text & " - " & tr1.Text & tr2.Text & " Seat! Total Amount is $" & amt * 50 & " Pls Click Confirm or Reject to Continue !"
        mbox.ForeColor = &H400000
    End If
    
    If (Mid$(sbuffer, 1, 2) = "NK") Then
        msg = Mid$(sbuffer, 3)
        mbox.Caption = "Sorry!    Some Seat Occupied by other! Try Again"
        mbox.ForeColor = &HFF&
    End If
    
    If (Mid$(sbuffer, 1, 2) = "EK") Then
        For i = 3 To TSEAT
            Check1(i - 3) = (Mid$(sbuffer, i, 1))
        Next i
    End If
End Sub

Private Sub Connect_Click()
        
    If Socket1.Connected Then
        Socket1.Action = SOCKET_CLOSE
        Connect.Enabled = True
        Connect.Caption = "Connect"
        Enquiry.Enabled = False
        
    Else
        Connect.Enabled = False
        Enquiry.Enabled = True
        Socket1.HostName = "127.0.0.1"
        Socket1.LocalPort = IPPORT_ANY
        Socket1.RemotePort = IPPORT_ECHO

        If (Socket1.Connect <> 0) Then
            MsgBox "Host Not Connect", vbInformation
        End If
    End If

End Sub

Private Sub Text1_Change()
    If (Len(Text1.Text) < 2) Then
        Buy.Enabled = False
    Else
        Buy.Enabled = True
    End If
End Sub


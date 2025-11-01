<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
 <html>
   <xsl:apply-templates/>
 </html>
</xsl:template>

<xsl:template match="Jobs">
   <body bgcolor="#CCCCCC">
   <center>
   <font color="#000099" size="+2" face="Comic Sans MS"><b>Jobs : </b></font><br/><br/>
   <font color="#000000" size="3" face="Arial">
   <table width="54%" border="0">
      
      <tr>
        <xsl:for-each select="job/header">
          <xsl:sort select = "@priority" order = "descending"/>
          <xsl:sort select = "@stdate" order = "descending"/>
             <xsl:if test = "position() = 1">
               <tr><td><b><xsl:value-of select="@title"/></b></td></tr>
               <tr><b><td><xsl:value-of select="../body"/></td></b></tr>             
             </xsl:if>      
        </xsl:for-each>
      </tr>
   </table>
   </font>
   
   </center>
   </body>
</xsl:template>
</xsl:stylesheet>

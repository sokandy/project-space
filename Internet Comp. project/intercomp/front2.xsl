<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
 <html>
   <xsl:apply-templates/>
 </html>
</xsl:template>

<xsl:template match="categories">
   <body bgcolor="#CCCCCC">
   <center>
   
   <font color="#000000" size="3" face="Arial">
   <table width="54%" border="0">
      <tr>
         <td><b>Section:</b></td><td><b>Importance:</b></td>
      </tr>
      
      <tr>
      
      <xsl:for-each select="category">
        <xsl:sort select = "items" order = "descending"/>
         
         <xsl:if test = "title = 'Property'">
           <xsl:if test = "position() = 1">
             <td><xsl:value-of select="title"/></td>
             <td><xsl:value-of select="items"/></td>
           </xsl:if>    
	 </xsl:if> 
         
      </xsl:for-each>
      
      </tr>
   </table>
   </font>
   
   </center>
   </body>
</xsl:template>
</xsl:stylesheet>

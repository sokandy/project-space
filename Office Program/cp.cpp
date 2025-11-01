#include <errno.h>
#include <dirent.h>
#include <stdio.h>
#include <fcntl.h>
#include <io.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <dir.h>

void gpatform(char pat[], char source[]);
void gextform(char ext[], char source[]);

int main(int argc, char *argv[]) {
	DIR *dir;
	struct dirent *ent;
   int rfd,wfd,len,tmp,noct=0;
   struct stat stbuf;
   char newfname[20],pat[10],ext[5],ins[5];
   char buf[1024],prndir[MAXPATH],curdir[MAXPATH];

   if (argc < 5) {
   	perror("not enough parameter");
      printf("\n[Usage] : cp source-dir destination-dir file");
      printf("\%");
      printf(" number\n");
      return 1;
   }

	if (!(dir = opendir(argv[1]))) {
		perror("source dir");
		return 1;
	}

   if ((tmp=atoi(argv[4]))==0) {
   	perror ("int");
      return 1;
   }

  	if (chdir(argv[2])) {   /* Get the current directory */
		perror("target dir");
  		return 1;
	}
   getcwd(curdir, MAXPATH);

   gpatform(pat,argv[3]);
	errno=0;
   while ((ent = readdir(dir))) {
     	if (chdir(argv[1])) {
  			perror("chdir()");     /* change to source directory */
     		return 1;
  		}
      if ((stat(ent->d_name,&stbuf)) == -1) {
      	perror("stat");
         return 1;
      }
      if ((stbuf.st_mode & S_IFMT) != S_IFDIR) {
         if ((rfd=open(ent->d_name,O_RDONLY|O_BINARY)) < 0) {
      		perror("open1");
         	return 1;
         }

         /* start change the format of the file name
         	with standard pattern */
         gextform(ext,ent->d_name);
         strcpy(newfname,pat);
         itoa(tmp,ins,10);       /* tmp = start no. change to string ins */
         strcat(newfname,ins);
         strcat(newfname,ext);
         tmp++;

        	if (chdir(argv[2])) {   /* change the target directory */
     			perror("target dir");
      		return 1;
   		}
         if ((wfd=open(newfname,O_CREAT|O_EXCL|O_RDWR|O_BINARY,S_IWRITE)) < 0){
         	perror("open2");
            return 1;
         }
         while ((len=read(rfd,buf,sizeof(buf))) > 0) {
         	if (write(wfd,buf,len) != len) {
            	perror("write");
               return 1;
            }
         }
         if (len<0) {
         	perror("read");
            return 1;
         }
      	strcpy(prndir,curdir);
      	strcat(prndir,"\\");
	   	strcat(prndir,newfname);
      	puts(prndir);
      	noct++;        /* no of file created */
      }
   	errno=0;
      close(rfd);
      close(wfd);
   }
   printf("        %d file(s) created\n",noct);

	if (errno) {
		perror("readdir");
		return 1;
	}

	closedir(dir);

	return 0;
}

void gextform(char ext[], char s[]) {
	int i,j,out=0;

   for (i=j=0 ; s[i]!='\0' ; i++) {
   	if (out != 1 && s[i] == '.') {    /* get the pattern of filename */
      	ext[j++]=s[i];
         out=1;
      }
      else if (out == 1)
      	ext[j++]=s[i];
   }
   ext[j]='\0';
}

void gpatform(char pat[], char s[]) {
	int i,j;

   for (i=j=0; s[i]!='%'; i++)
   	pat[j++] = s[i];
   pat[j]='\0';
}

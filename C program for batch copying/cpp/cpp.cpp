#include <errno.h>
#include <dirent.h>
#include <stdio.h>
#include <fcntl.h>
#include <io.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <dir.h>


void cpname(char s[], char c[]);


int main(int argc, char *argv[]) {
	DIR *dir;
	struct dirent *ent;
   int rfd,wfd,flag;
   struct stat stbuf;
   char line[13];

   if (argc <= 1) {
   	perror("no source");
      return 1;
   }

	if (!(dir = opendir(argv[1]))) {
		perror("opendir");
		return 1;
	}

   if (chdir(argv[1])) {
     	perror("chdir()");
      return 1;
   }
	errno=0;
   flag=0;
   while ((ent = readdir(dir))) {
   	puts(ent->d_name);
   	flag++;
      if (flag>2){
      	if ((rfd=open(ent->d_name,O_RDONLY)) == -1) {
      		perror("open");
         	return 1;
         }
      }
    //     cpname(line,ent->d_name);
    //     if ((wfd=open(line,O_CREAT|O_WRONLY,S_IWRITE)) < 0) {
    //     	perror("write");
    //        return 1;
    //     }
    //
    //     printf("%s",line);
//      }
      errno=0;
   }
	if (errno) {
		perror("readdir");
		return 1;
	}

	closedir(dir);

	return 0;
}

void cpname(char c[], char s[]) {
	int i,j;

   for (i=j=0;s[i] != '\0';i++)
   	if (i!=1)
      	c[j++] = s[i];
      else {
      	c[j++] = '_';
         c[j++] = s[i];
      }
   c[j]='\0';
}



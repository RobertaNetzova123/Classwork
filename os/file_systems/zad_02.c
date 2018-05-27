#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <pwd.h>


int main(int argc, char **argv)
{
  struct stat st;
  struct passwd *psw;

  for (int i = 1; i < argc; i++) {

    char* file_name = argv[i];
    int rc = stat(file_name, &st);
    psw = getpwuid(st.st_uid);

    if(rc != 0)
    {
      perror("stat");
      return 1;
    }

    if (psw == NULL) {
      perror("getpwuid() error.");
      return 2;
    }
    
    printf("%s %s\n", file_name, psw->pw_name);
  }

  return 0;
}
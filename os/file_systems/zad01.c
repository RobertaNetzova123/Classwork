#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
int main(int argc, char **argv)
{
	struct stat st;
	for (int i = 1; i < argc; i++) {

		char* file_name = argv[i];
		int rc = stat(file_name, &st);

		if(rc != 0)
		{
			perror("stat");
			return 1;
		}
		printf("%s %d\n", file_name, st.st_size);
	}

	return 0;
}
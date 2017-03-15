CS3524_HOME="$(HOME)/3524"

RM_FLAGS="-f"

rmimud:
	javac code/mudServerImp.java; \
	javac code/mudServerMainline.java; \
	javac code/mudClient.java; 

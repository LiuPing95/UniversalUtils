#!/bin/zsh
rootPath=/Users/liuping/workspace/jsyl/dm-fddh-backend-basic-spring
function clearIdea() {
  for file in $(ls -a $1); do
    # 跳过这些目录，因为一直  ls -a .  就会导致死循环
    # .git文件不做任何处理
    # src已经到了代码层面了，里面的文件也不需要处理
    if [[ "$file" == "." || "$file" == ".." || "$file" == ".git" || "$file" == "src" ]]; then
      continue
    fi
    # 当前是个目录
    if [ -d "$1/$file" ]; then
      if [[ "$file" == ".idea" || "$file" == "target" || "$file" == "node_modules" || "$file" == "dist" ]]; then
        echo "$file"
        rm -rf "$1/$file"
        continue
      fi
      clearIdea "$1/$file"
      # 是个文件
    else
      if [[ "$file" == *".iml" ]]; then
        rm -f "$1/$file"
        echo "$file"
      fi
    fi
  done
}

function clearMaven() {
  for file in $(ls -a $1); do
    if [[ "$file" == "." || "$file" == ".." ]]; then
      continue
    fi
#    echo "$file"
    if [[ -d "$1/$file" ]]; then
      if [[ `ls "$1/$file"` == "" ]]; then
        echo "$file" is a empty dir
        rm -rf "$1/$file"
      fi
      clearMaven "$1/$file"
    fi
  done
}
clearMaven /Users/liuping/.m2/repository

#clearIdea $rootPath

#!/bin/bash
ssh-add ~/.ssh/dx_qq_github_ed255519 
time=$(date "+%Y-%m-%d-%H:%M:%S")
echo $time
git add -A
git commit -m $time
git push origin

ssh-add ~/.ssh/dx_neteaselab_ef25519

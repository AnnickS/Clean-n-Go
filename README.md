# CS331 Project 2 Clean n Go

Clean n Go

Employees: Nikita, Ahmed, Annick, Andre

A clothing cleaning company database

Check out the code standards and git crash course below.

## Notes

### equipment and cleaning supply can be expressed as a **UNION**
   This means that we don't need to have flags of any sort. Just
   primary keys.

### having no connection between supply usage an services seems eerie
   Perhaps a relation between _service_ and _item_ could be added
   to update the current inventory after each service.

---

## Code Standards

### entities in this document are shown in _italics_
   words are delimited with underscores (e.g. web_host).

### attributes are shown in 'single quotes'
   words are delimited with camel casing.

---

## git crash course
  1. install git https://git-scm.com/
  2. clone this repository
     - This can be done with the terminal in two ways:
       + `git clone https://gitlab.com/AnnickS1/cs331-project-2-clean-n-go.git`
       + `git clone https://<your username here>@gitlab.com/AnnickS1/cs331-project-2-clean-n-go.git`
  3. type `git status`

     This shows your current branch (as well as any changes that have been
     made).
  4. Please do not make direct changes to the master branch. 
     This is difficult to fix. Instead, make a new one:

     `git branch <new branch name>`
  5. Switch to the new branch: `git checkout <new branch>`
  6. Write some code, change some files.
     Now take a look at how git recognizes this info.

     `git status`

     This will show some important information:
     + what branch you are currently working in
     + what files have been changed so far *and*
       whether they have been declared for changes
       in the current code base.
     There may be some unimportant data generated
     by your system/IDE. If you want git to ignore
     these files, add a regex pattern to .gitignore
     within the current repo and commit it before
     commiting any other files.
     In other words:
     + add regex patterns for git to the ignore file
     + `git add .gitignore`
     + `git commit -m "made changes to gitignore"`

     Now type `git status` again and your junk files
     should no longer be candidates for staging of
     any sort.
  7. Upload your branch to the cloud repository to
     save your work.

     `git push`
  8. If you've completed a feature, you can add it
     to the master branch.
     ```
     git checkout master
     git status
     git merge <completed feature branch>
     ```
     which adds all your work to the master branch
     then, upload the master branch too.

     `git push`

# CS331 Project 2 Clean n Go

Clean n Go

Employees: Nikita, Ahmen, Annick, Andre

A clothing cleaning company database

* Code Standards
** entities in this document are shown in /italics/
   words are delimited with underscores (e.g. web_host).
** attributes are shown in 'single quotes'
   words are delimited with camel casing.
* Notes
** equipment and cleaning supply can be expressed as a *UNION*
   This means that we don't need to have flags of any sort. Just
   primary keys.
** having no connection between supply usage an services seems eerie
   Perhaps a relation between /service/ and /item/ could be added
   to update the current inventory after each service.

	org	0
	mov	al,11
	mov	bl,14
	
giroe:	out	05
	rol	al
	dec	bl
	jnz	giroe

girod:	out	05
	ror	al
	dec	bl
	jnz	girod
	
	end
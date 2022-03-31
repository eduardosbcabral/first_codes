	mov	dl,90
	mov	cl,c0
le:	in	00
	cmp	al,0d
	jz	mostra
	mov	[dl],al
	inc	dl
	jmp	le
mostra:	mov	bl,90
disp:	mov	al,[bl]
	mov	[cl],al
	inc	cl
	inc	bl
	cmp	bl,dl
	jnz	disp
	end
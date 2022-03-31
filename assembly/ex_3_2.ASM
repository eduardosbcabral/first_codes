	mov	dl,60
	mov	al,5
prox:	mov	[dl],al
	inc	dl
	add	al,2
	cmp	dl,70
	jnz	prox
	mov	dl,60
	mov	al,[dl]
	inc	dl
check:	mov	bl,[dl]
	xor	al,bl
	inc	dl
	cmp	dl,70
	jnz	check
	mov	[70],al
	end

/*
<div class="rolling main">
	<ul>
		<li><img></li>
		<li><img></li>
		<li><img></li>
	</ul>
	<ol>
		<li></li>
		<li></li>
		<li></li>
	</ol>
	<div class="prev"><span></span></div>
	<div class="next"><span></span></div>
</div>


.rolling {  position:relative; width:100%; height:100%; overflow:hidden; }
.rolling ul { position:relative; left:0; top:0; height:100%; }
.rolling ul:after { display:block; clear:both; content:''; }
.rolling ul li { position:absolute; left:0; top:0; width:100%; height:; }

.rolling ol { position:absolute; top:10px; left:10px; }
.rolling ol:after { display:block; clear:both; content:''; }
.rolling ol li { float:left; width:9px; height:9px; border:1px solid #444;   margin-left:6px; cursor:pointer;
	border-radius:100%;
	-webkit-border-radius:100%;
	transition:all 0.4s;
	-webkit-transition:all 0.4s;
}
.rolling ol li:first-child { margin-left:0; }
.rolling ol li.on { background:#4186A7; border-color:#444;  }

.rolling div { position:absolute;  width:22px; height:29px; margin-top:-15px; background:url('../../img/btn_roll.jpg') no-repeat 0 0; border:none; cursor:pointer; 	}
.rolling *::selection { background:none; }
.rolling *::-webkit-selection { background:none; }
.rolling div.on { height:51px;  }
.rolling div:hover { width:51px; background-position:-22px 0;  }
.rolling div span { display:none; line-height:29px; padding-left:18px; }
.rolling div:hover span { display:block; }
.rolling div.prev { left:0; top:50%; }
.rolling div.next { position:absolute; left:initial; right:0; top:50%;  margin-top:-20px; background-position:0 -29px; }
.rolling div.next:hover { background-position:-22px -29px; text-align:left;  }
.rolling div.next span { padding-left:10px; }

*/

	// jQuery plugin setting
	$.prototype.rolling = function( options ){ 
		this.each(function(){ 
			new Rolling( this , options);
		});
	}

	// polymorphism - direction
	$.rollingDeirect = { 
		horizontal : { 
			effect : function( opts ){ 
			
				var currentEndLeft  = '100%';
				var nextStartLeft = '-100%';

				 if( opts.direct == 'next'  ){
					currentEndLeft = '-100%';
					nextStartLeft = '100%';
				}

				opts.currentImage.css({ 
					left : 0 , 
					opacity:1 ,
				}).stop().animate({
					left: currentEndLeft ,
					opacity: opts.opacity ,
				}, opts.duration , opts.easing ); 

				opts.nextImage.css({ 
					left : nextStartLeft , 
					opacity: opts.opacity, 
				}).stop().animate({ 
					left : 0 ,
					opacity: 1
				}, opts.duration , opts.easing );
				
			}
		} ,
		vertical : { 
			effect : function(  opts ){ 

				var currentEndTop = '100%';
				var nextStartTop = '-100%';

				if( opts.direct == 'next' ){
					currentEndTop = '-100%' ;
					nextStartTop = '100%';
				}

				opts.currentImage.css({ 
					top: 0 ,
					left: 0 ,
					opacity:1 ,
				}).stop().animate({
					top : currentEndTop , 
					opacity: opts.opacity ,
				}, opts.duration , opts.easing ); 

				opts.nextImage.css({ 
					top : nextStartTop ,
					left: 0 ,
					opacity: opts.opacity, 
				}).stop().animate({ 
					top : 0 ,
					opacity: 1
				}, opts.duration , opts.easing );
				
			}
		}
	}
	
	// Rolling Class define
	function Rolling( selector ,  options){ 
		
		this.$selector = $(selector);
		this._$image = null;
		this._$nav = null;
		this._$prev = null;
		this._$next = null;
		this._currentIndex = -1;
		this._timerID = 0;
		this._options = null;

		this._$bg = null;
		this._init();
		this._initOptions(options);
		this._initEvent();
		this._initPos( this._options.startIndex );
		this.showImage( this._options.startIndex );
		this.startAutoPlay();
	}
	
	// Rolling default options 
	Rolling.defaultOptions = { 
		startIndex : 0 , 
		animationEffect : true ,
		autoPlayDelayTime : 4000,
		duration : 400 ,
		easing :'swing',
		opacity : 0 , 
		nav : true , 
		btn : true , 
		autoPlay : false , 
		mode : $.rollingDeirect.horizontal ,
		click : false , 
	}
	
	// options initialize
	Rolling.prototype._initOptions = function(options){ 
		this._options = $.extend({} , Rolling.defaultOptions , options );
	}
	
	// dom elements initialize
	Rolling.prototype._init = function(){ 
		this._$image = this.$selector.find('ul > li');
		this._$bg = this.$selector.find('.bg div');
		this._$nav = this.$selector.find('ol > li');
		this._$prev = this.$selector.find('.prev');
		this._$next = this.$selector.find('.next');

	}
	
	// event handler initialize
	Rolling.prototype._initEvent = function(){

		var objThis = this;
		
		var mouseEvent = ( this._options.click ) ? 'click' : 'mouseenter';

		// navigaion
		this._$nav.on( mouseEvent , function(){ 
			var index = $(this).index();
			if( index == objThis._currentIndex ){
				return;
			}
			if( index > objThis._currentIndex ){
				objThis.showImage( index , "next");
			} else {
				objThis.showImage( index , "prev");
			}
		});
	
		// button prev
		this._$prev.on({ 
			click : function(){  
				objThis.prevImage();
			} 
		});

		// button next
		this._$next.on({ 
			click : function(){  
				objThis.nextImage();
			} 
		});

		// timer event 
		if( this._options.autoPlay ){
			this.$selector.on({ 
				mouseenter : function(){
					objThis.stopAutoPlay();
				} , 
				mouseleave : function(){ 
					objThis.startAutoPlay();
				}
			});
		}


	}
	
	// show prevSlide
	Rolling.prototype.prevImage = function(){ 
		this.showImage( this._currentIndex - 1 , "prev" );		
	}
	
	// show nextSilde
	Rolling.prototype.nextImage = function(){ 
		this.showImage( this._currentIndex + 1 , "next" );		
	}

	// initialize banner position
	Rolling.prototype._initPos = function(index){ 

		var objThis = this;

		this._$image.not(':eq(0)').each(function(){ 
			$(this).css({  
				opacity: objThis._options.opacity ,
				left : '-100%' ,
			});
		});

		if( this._options.nav == false ){ 
			this._$nav.hide();
		}
		if( this._options.btn == false ){ 
			this._$prev.hide();
			this._$next.hide();
		}

	}

	// show slideBanner
	Rolling.prototype.showImage = function(index , direct ){ 

		if( index < 0 ){
			index  = this._$image.length - 1;
		}
		if( index > this._$image.length - 1 ){
			index = 0;
		}

		var $currentImage = this._$image.eq( this._currentIndex );
		var $nextImage = this._$image.eq(index);
		
		if( this._options.animationEffect == false ){
			direct = false;
		}
		
		if( direct ){

			this._options.mode.effect({ 
				direct : direct, 
				currentImage : $currentImage , 
				nextImage : $nextImage , 
				duration : this._options.duration , 
				easing : this._options.easing ,
			});
		} else {
			$currentImage.animate({ 
				opacity: this._options.opacity  ,
				zIndex:1 
			});

			this._$bg.eq(this._currentIndex).animate({ opacity: this._options.opacity });

			$nextImage.css({ left:0 });
			$nextImage.animate({
					opacity:1 ,
					zIndex : 2
			});

			this._$bg.eq(index).animate({
					left: 0 ,
					opacity:1 
			});

		}

		this._showCnt( index );
		this._showNav( index );
		this._currentIndex = index;
		
	}

	// show button number
	Rolling.prototype._showCnt = function(index){ 
		
		var totalCnt = this._$image.length;
		var startCnt = index + 1;
		var text = startCnt + "/" + totalCnt;

		this._$prev.children('span').text(text);
		this._$next.children('span').text(text);
	}
	
	// show current navigaion
	Rolling.prototype._showNav = function(index){ 

		if( this.currentIndex != -1 ){
			this._$nav.eq(this._currentIndex).removeClass('on');
		}

		this._$nav.eq(index).addClass('on');
	}

	// start auto timer 
	Rolling.prototype.startAutoPlay = function(){ 
		if( this._options.autoPlay == true ){
			if(this._timerID == 0 ){
				this._timerID = setInterval( $.proxy( function(){ 
					this.nextImage();
				}, this ) , this._options.autoPlayDelayTime);
			}
		}
	}
	
	// end auto timer
	Rolling.prototype.stopAutoPlay = function(){
		if( this._timerID != -1 ){
			clearInterval( this._timerID );
			this._timerID = 0;
		}
	}

	





angular.module('app')
    .config([
        '$ocLazyLoadProvider', function ($ocLazyLoadProvider) {
            $ocLazyLoadProvider.config({
                debug: true,
                events: true,
                modules: [
                    {
                        name: 'toaster',
                        files: [
                            'lib/modules/angularjs-toaster/toaster.css',
                            'lib/modules/angularjs-toaster/toaster.js'
                        ]
                    },
                    {
                        name: 'ui.select',
                        files: [
                            'lib/modules/angular-ui-select/select.css',
                            'lib/modules/angular-ui-select/select.js'
                        ]
                    },
                    {
                        name: 'ngTagsInput',
                        files: [
                            'lib/modules/ng-tags-input/ng-tags-input.js'
                        ]
                    },
                    {
                        name: 'daterangepicker',
                        serie: true,
                        files: [
                            'lib/modules/angular-daterangepicker/moment.js',
                            'lib/modules/angular-daterangepicker/daterangepicker.js',
                            'lib/modules/angular-daterangepicker/angular-daterangepicker.js'
                        ]
                    },
                    {
                        name: 'vr.directives.slider',
                        files: [
                            'lib/modules/angular-slider/angular-slider.min.js'
                        ]
                    },
                    {
                        name: 'minicolors',
                        files: [
                            'lib/modules/angular-minicolors/jquery.minicolors.js',
                            'lib/modules/angular-minicolors/angular-minicolors.js'
                        ]
                    },
                    {
                        name: 'textAngular',
                        files: [
                            'lib/modules/text-angular/textAngular-sanitize.min.js',
                            'lib/modules/text-angular/textAngular-rangy.min.js',
                            'lib/modules/text-angular/textAngular.min.js'
                        ]
                    },
                    {
                        name: 'ng-nestable',
                        files: [
                            'lib/modules/angular-nestable/jquery.nestable.js',
                            'lib/modules/angular-nestable/angular-nestable.js'
                        ]
                    },
                    {
                        name: 'angularBootstrapNavTree',
                        files: [
                            'lib/modules/angular-bootstrap-nav-tree/abn_tree_directive.js'
                        ]
                    },
                    {
                        name: 'ui.calendar',
                        files: [
                            'lib/jquery/fullcalendar/jquery-ui.custom.min.js',
                            'lib/jquery/fullcalendar/moment.min.js',
                            'lib/jquery/fullcalendar/fullcalendar.js',
                            'lib/modules/angular-ui-calendar/calendar.js'
                        ]
                    },
                    {
                        name: 'ngGrid',
                        files: [
                            'lib/modules/ng-grid/ng-grid.min.js',
                            'lib/modules/ng-grid/ng-grid.css'
                        ]
                    },
                    {
                        name: 'dropzone',
                        files: [
                            'lib/modules/angular-dropzone/dropzone.js',
                            'lib/modules/angular-dropzone/angular-dropzone.js'
                        ]
                    },
                    {
                        name: 'pagination',
                        files: [
							'assets/common/js/pagination-with-styles.js',
							'assets/common/js/juicer.js'
                        ]
                    }
                ]
            });
            angular.module('pagination', []);
        }
    ]);